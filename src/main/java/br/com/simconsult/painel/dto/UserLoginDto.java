package br.com.simconsult.painel.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserLoginDto {

	@Email(message = "Invalid email address")
	private String email;

	@NotBlank(message = "Password requerid")
	private String password;

	public UserLoginDto() {
		super();
	}

	public UserLoginDto(@Email(message = "Invalid email address") String email,
			@NotBlank(message = "Password requerid") String password) {
		super();
		this.email = email;
		this.password = password;
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

}
