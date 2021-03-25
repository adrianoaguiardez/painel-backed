package br.com.simconsult.painel.payload.reponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.simconsult.painel.modelo.Role;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private Role role;

	private boolean admin = true;
	@JsonIgnore
	private List<String> roles;

	public JwtResponse(String accessToken, Long id, String username, String email, Role role, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.role = role;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public Role getRole() {
		return role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public boolean isAdmin() {
		return role.equals(Role.ADMINISTRATOR);
	}

}
