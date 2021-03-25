package br.com.simconsult.painel.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.simconsult.painel.model.PageModel;
import br.com.simconsult.painel.model.PageRequestModel;
import br.com.simconsult.painel.modelo.Cidade;
import br.com.simconsult.painel.modelo.Cliente;
import br.com.simconsult.painel.modelo.Pessoa;
import br.com.simconsult.painel.modelo.TipoPessoa;
import br.com.simconsult.painel.payload.reponse.ClienteResponse;
import br.com.simconsult.painel.payload.request.ClienteRequest;
import br.com.simconsult.painel.security.AccessManager;
import br.com.simconsult.painel.service.CidadeService;
import br.com.simconsult.painel.service.ClienteService;
import br.com.simconsult.painel.service.GrupoPostoService;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private GrupoPostoService grupoPostoService;

	@Autowired
	private AccessManager accessManager;

	@GetMapping
	public ResponseEntity<PageModel<Cliente>> findAll(@RequestParam Map<String, String> params) {
		PageRequestModel pr = new PageRequestModel(params);

		PageModel<Cliente> pm = clienteService.listAllOnLazyModel(accessManager.selecionarCliente().getCodigo(), pr);
		return ResponseEntity.ok(pm);
	}

	@GetMapping("/buscar")
	public ResponseEntity<List<Cliente>> findAll() {

		List<Cliente> clientes = clienteService.listAll();

		return ResponseEntity.ok(clientes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteResponse> findById(@PathVariable Long id) {

		Cliente clienteRetorno = clienteService.getCliente(id);

		ClienteResponse clienteResponse = new ClienteResponse(clienteRetorno.getCodigo(),
				clienteRetorno.getPessoa().getNome(), clienteRetorno.getPessoa().getDocument(),

				clienteRetorno.getPessoa().getTelefone(), clienteRetorno.getPessoa().getEmail(),
				clienteRetorno.getPessoa().getTipoPessoa(), clienteRetorno.getNomeFantasia(),
				clienteRetorno.getCidade().getEstado().getCodigo(), clienteRetorno.getCidade().getCodigo(),
				clienteRetorno.getGrupoPosto().getId());

		return ResponseEntity.ok(clienteResponse);
	}

	@GetMapping("tiposPessoas")
	public ResponseEntity<List<TipoPessoa>> tiposPessoas() {

		return ResponseEntity.ok(Arrays.asList(TipoPessoa.values()));
	}

	@PostMapping("/novo")
	public ResponseEntity<?> salvarNovo(@RequestBody @Valid ClienteRequest clienteRequest) {

		Pessoa pessoa = new Pessoa(null, clienteRequest.getNome(), null, null, clienteRequest.getDocument(),
				clienteRequest.getEmail(), clienteRequest.getTelefone(), clienteRequest.getTipoPessoa());

		Cidade cidadeBanco = cidadeService.findById(clienteRequest.getCidade());

		Cliente cliente = new Cliente(null, null, clienteRequest.getNomeFantasia(), LocalDate.now(), true, pessoa, null,
				null, cidadeBanco,
				clienteRequest.getGrupoPosto() != null ? grupoPostoService.getId(clienteRequest.getGrupoPosto()) : null,
				accessManager.selecionarCliente());

		Cliente clienteBanco = clienteService.salvarMatriz(cliente);

		return ResponseEntity.status(HttpStatus.CREATED).body(clienteBanco);
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody @Valid ClienteRequest clienteRequest) {

		Pessoa pessoa = new Pessoa(null, clienteRequest.getNome(), null, null, clienteRequest.getDocument(),
				clienteRequest.getEmail(), clienteRequest.getTelefone(), clienteRequest.getTipoPessoa());

		Cidade cidadeBanco = cidadeService.findById(clienteRequest.getCidade());

		Cliente cliente = new Cliente(null, null, clienteRequest.getNomeFantasia(), LocalDate.now(), true, pessoa, null,
				null, cidadeBanco,
				clienteRequest.getGrupoPosto() != null ? grupoPostoService.getId(clienteRequest.getGrupoPosto()) : null,
				accessManager.selecionarCliente());

		Cliente clienteBanco = clienteService.salvar(cliente);

		return ResponseEntity.status(HttpStatus.CREATED).body(clienteBanco);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody ClienteRequest clienteRequest) {

		Cliente cliente = clienteService.atualizar(id, clienteRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}

}
