package br.com.simconsult.painel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.simconsult.painel.dto.UserLoginDto;
import br.com.simconsult.painel.modelo.Role;
import br.com.simconsult.painel.modelo.Usuario;
import br.com.simconsult.painel.modelo.UsuarioCliente;
import br.com.simconsult.painel.payload.reponse.JwtResponse;
import br.com.simconsult.painel.payload.reponse.UserResponse;
import br.com.simconsult.painel.payload.request.JwtResquest;
import br.com.simconsult.painel.payload.request.UserRequest;
import br.com.simconsult.painel.security.AccessManager;
import br.com.simconsult.painel.security.jwt.JwtUtils;
import br.com.simconsult.painel.security.service.UserDetailsImpl;
import br.com.simconsult.painel.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "users")
public class UserResource {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	private AccessManager accessManager;

	@PostMapping
	private ResponseEntity<Usuario> save(@RequestBody @Valid UserRequest userRequest) {

		Usuario userToSave = new Usuario(null, userRequest.getName(), userRequest.getEmail(), userRequest.getPassword(),
				userRequest.isAdmin() ? Role.ADMINISTRATOR : Role.SIMPLE, accessManager.selecionarCliente());
		Usuario createUser = userService.save(userToSave);

		return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
	}

	@PutMapping("/{id}")
	private ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody @Valid UserRequest userRequest) {

		Usuario createUser = userService.update(id, userRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
	}

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody @Valid UserLoginDto user) {

		Authentication authentication = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		String jwt = jwtUtils.generateJwtToken(authentication);

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
				userDetails.getEmail(), userDetails.getRole(), roles));
	}

	@PostMapping("/refresh")
	public ResponseEntity<JwtResponse> atualizarToken(@RequestBody @Valid JwtResquest jwtResponse) {

		String jwt = jwtUtils.getUserNameFromJwtToken(jwtResponse.getAccessToken());

		UserDetailsImpl userDetails = (UserDetailsImpl) userService.loadUserByUsername(jwt);
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
				userDetails.getEmail(), userDetails.getRole(), roles));
	}

	@GetMapping
	public ResponseEntity<List<UserResponse>> listaUsuarios() {
		List<UsuarioCliente> listaUsuarios = userService.listAll(accessManager.selecionarCliente().getCodigo());

		List<UserResponse> list = new ArrayList<>();
		
		listaUsuarios.forEach(usuarioRetorno->{
			UserResponse userResponse = new UserResponse(usuarioRetorno.getUsuario().getCodigo(), usuarioRetorno.getUsuario().getName(),
					usuarioRetorno.getUsuario().getEmail(), null, null,
					usuarioRetorno.getUsuario().getRole().equals(Role.ADMINISTRATOR) ? true : false);
			
			
			list.add(userResponse);
		});

		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> findById(@PathVariable Long id) {

		Usuario usuarioRetorno = userService.getById(id);

		UserResponse userResponse = new UserResponse(usuarioRetorno.getCodigo(), usuarioRetorno.getName(),
				usuarioRetorno.getEmail(), null, null,
				usuarioRetorno.getRole().equals(Role.ADMINISTRATOR) ? true : false);

		return ResponseEntity.ok(userResponse);
	}

}
