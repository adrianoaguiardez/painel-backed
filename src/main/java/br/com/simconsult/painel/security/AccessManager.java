package br.com.simconsult.painel.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.simconsult.painel.exception.NotFoundException;
import br.com.simconsult.painel.modelo.Cliente;
import br.com.simconsult.painel.modelo.Usuario;
import br.com.simconsult.painel.repository.UserRepository;
import br.com.simconsult.painel.security.service.UserDetailsImpl;
import br.com.simconsult.painel.service.ClienteService;

@Component("accessManager")
public class AccessManager {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClienteService clienteService;

	public Cliente selecionarCliente() {

		UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		Optional<Usuario> result = userRepository.findByEmail(userDetails.getEmail());

		if (!result.isPresent()) {
			throw new NotFoundException("There are note user with email = " + userDetails.getEmail());
		}

		Usuario user = result.get();

		Cliente cliente = clienteService.getClienteDoUsuario(user.getCodigo());
		return cliente;
	}

	public Usuario usuario() {
		UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		Optional<Usuario> result = userRepository.findByEmail(userDetails.getEmail());

		if (!result.isPresent()) {
			throw new NotFoundException("There are note user with email = " + userDetails.getEmail());
		}

		Usuario user = result.get();

		return user;
	}

}
