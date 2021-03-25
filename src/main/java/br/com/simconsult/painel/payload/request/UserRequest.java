package br.com.simconsult.painel.payload.request;

import javax.validation.constraints.NotBlank;

public class UserRequest {

	private Long id;

	@NotBlank(message = "O Nome é obriga†ório")
	private String name;

	@NotBlank(message = "O e-mail é obriga†ório")
	private String email;

	@NotBlank(message = "Informe a senha do usuário")
	private String password;

	@NotBlank(message = "Informe a confirmação de senha")
	private String confirmPassword;

	private boolean admin = false;

	@Deprecated
	public UserRequest() {

	}

	public UserRequest(Long id, String name, String email, String password, String confirmPassword, boolean admin) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.admin = admin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
