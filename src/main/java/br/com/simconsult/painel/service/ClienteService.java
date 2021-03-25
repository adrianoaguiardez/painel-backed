package br.com.simconsult.painel.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.simconsult.painel.model.PageModel;
import br.com.simconsult.painel.model.PageRequestModel;
import br.com.simconsult.painel.modelo.Cidade;
import br.com.simconsult.painel.modelo.Cliente;
import br.com.simconsult.painel.modelo.Role;
import br.com.simconsult.painel.modelo.Usuario;
import br.com.simconsult.painel.modelo.UsuarioCliente;
import br.com.simconsult.painel.payload.request.ClienteRequest;
import br.com.simconsult.painel.repository.ClientesRepository;
import br.com.simconsult.painel.repository.PessoasRepository;
import br.com.simconsult.painel.repository.UserClienteRepository;
import br.com.simconsult.painel.security.AccessManager;

@Service
public class ClienteService {

	@Autowired
	private ClientesRepository repository;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private PessoasRepository pessoasRepository;

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private UserService userService;

	@Autowired
	private AccessManager accessManager;

	@Autowired
	private UserClienteRepository userClienteRepository;
	
	
	@Transactional
	public Cliente salvarMatriz(Cliente cliente) {

		boolean cadastroNovo = cliente.getCodigo() == null ? true : false;

		pessoasRepository.save(cliente.getPessoa());

		Cliente clienteSalvo = repository.save(cliente);

		if (cadastroNovo) {
			produtoService.cadastroInicialDeProdutos(clienteSalvo);

			Usuario user = new Usuario(null, clienteSalvo.getPessoa().getNome(), clienteSalvo.getPessoa().getEmail(),
					"123", Role.SIMPLE, clienteSalvo);

			userService.save(user);

			UsuarioCliente usuarioCliente = new UsuarioCliente(null, clienteSalvo, user);
			userClienteRepository.save(usuarioCliente);
		}

		return clienteSalvo;
	}

	@Transactional
	public Cliente salvar(Cliente cliente) {

		boolean cadastroNovo = cliente.getCodigo() == null ? true : false;

		pessoasRepository.save(cliente.getPessoa());

		Cliente clienteSalvo = repository.save(cliente);

		if (cadastroNovo) {
			produtoService.cadastroInicialDeProdutos(clienteSalvo);

			Usuario user = new Usuario(null, clienteSalvo.getPessoa().getNome(), clienteSalvo.getPessoa().getEmail(),
					"123", Role.SIMPLE, clienteSalvo);

			userService.save(user);

			UsuarioCliente usuarioCliente = new UsuarioCliente(null, accessManager.selecionarCliente(), user);
			userClienteRepository.save(usuarioCliente);
		}

		return clienteSalvo;
	}

	public List<Cliente> listAll() {

		return repository.findAll();
	}

	public PageModel<Cliente> listAllOnLazyModel(Long codigoCliente, PageRequestModel pr) {

		Pageable pageable = pr.toSpringPageRequest();
		Page<Cliente> page = repository.findAllByCodigoOrParentCodigo(codigoCliente, codigoCliente, pageable);

		PageModel<Cliente> pm = new PageModel<>((int) page.getTotalElements(), page.getSize(), page.getTotalPages(),
				page.getContent());

		return pm;
	}

	public Cliente atualizar(Long id, ClienteRequest clienteRequest) {
		Cliente clienteBanco = getCliente(id);
		Cidade cidadeBanco = cidadeService.findById(clienteRequest.getCidade());
		clienteBanco.getPessoa().setNome(clienteRequest.getNome());
		clienteBanco.setCidade(cidadeBanco);

		return salvar(clienteBanco);

	}

	public Cliente getCliente(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	public Cliente getClienteDoUsuario(Long id) {
		return userClienteRepository.findAllByUsuarioCodigo(id).stream().findFirst().get().getCliente();
	}

}
