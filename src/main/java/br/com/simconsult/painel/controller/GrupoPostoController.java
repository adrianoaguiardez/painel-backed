package br.com.simconsult.painel.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.simconsult.painel.modelo.GrupoPosto;
import br.com.simconsult.painel.payload.reponse.GrupoPostoResponse;
import br.com.simconsult.painel.payload.request.GrupoPostoRequest;
import br.com.simconsult.painel.service.GrupoPostoService;

@RestController
@RequestMapping("/grupopostos")
public class GrupoPostoController {

	@Autowired
	private GrupoPostoService grupoPostoService;

	@GetMapping
	public ResponseEntity<List<GrupoPosto>> findAll() {

		List<GrupoPosto> grupoPostos = grupoPostoService.listAll();

		return ResponseEntity.ok(grupoPostos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<GrupoPostoResponse> findById(@PathVariable Long id) {

		GrupoPosto grupoPosto = grupoPostoService.getId(id);
		GrupoPostoResponse grupoPostoResponse = new GrupoPostoResponse(grupoPosto.getId(), grupoPosto.getDescricao(),
				null);
		return ResponseEntity.ok(grupoPostoResponse);

	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody @Valid GrupoPostoRequest grupoPostoRequest) {

		// Cliente clienteBanco =
		// clienteService.getCliente(grupoPostoRequest.getCodigoCliente());

		GrupoPosto grupoPosto = new GrupoPosto(null, grupoPostoRequest.getDescricao());

		GrupoPosto grupoSalvo = grupoPostoService.salvar(grupoPosto);

		return ResponseEntity.status(HttpStatus.CREATED).body(grupoSalvo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody GrupoPostoRequest grupoPostoRequest) {

		GrupoPosto grupoSalvo = grupoPostoService.update(id, grupoPostoRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(grupoSalvo);
	}

}
