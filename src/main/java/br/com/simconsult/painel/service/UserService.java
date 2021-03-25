package br.com.simconsult.painel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.simconsult.painel.exception.NotFoundException;
import br.com.simconsult.painel.modelo.Usuario;
import br.com.simconsult.painel.modelo.UsuarioCliente;
import br.com.simconsult.painel.payload.request.UserRequest;
import br.com.simconsult.painel.repository.UserClienteRepository;
import br.com.simconsult.painel.repository.UserRepository;
import br.com.simconsult.painel.security.service.UserDetailsImpl;
import br.com.simconsult.painel.service.util.HashUtil;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserClienteRepository userClienteRepository;

	public Usuario save(Usuario user) {

		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);
		Usuario createUser = userRepository.save(user);
		return createUser;
	}

	public Usuario update(Long id, UserRequest userRequest) {

		Usuario usuarioBanco = getById(id);

		String hash = HashUtil.getSecureHash(userRequest.getPassword());
		usuarioBanco.setPassword(hash);

		Usuario updateUser = userRepository.save(usuarioBanco);

		return updateUser;
	}

	public Usuario getById(Long id) {
		Optional<Usuario> result = userRepository.findById(id);

		return result.orElseThrow(() -> new NotFoundException("There are not user with id = " + id));
	}

	public List<UsuarioCliente> listAll(Long codigoCliente) {
		List<UsuarioCliente> users = userClienteRepository.findAllByClienteCodigo(codigoCliente);
		return users;
	}

	public Usuario login(String email, String password) {

		password = HashUtil.getSecureHash(password);

		Optional<Usuario> result = userRepository.login(email, password);
		return result.get();
	}

	public Usuario findByEmail(String email) {

		Optional<Usuario> result = userRepository.findByEmail(email);
		return result.get();
	}

	public int updateRole(Usuario user) {
		return userRepository.updateRole(user.getCodigo(), user.getRole());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> result = userRepository.findByEmail(username);

		if (!result.isPresent()) {
			throw new UsernameNotFoundException("Dosen't exist user with email = " + username);
		}

		Usuario user = result.get();

		return UserDetailsImpl.build(user);
	}
}
