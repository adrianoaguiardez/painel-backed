package br.com.simconsult.painel.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.simconsult.painel.modelo.Usuario;

public class UserUpdateDto {

	@NotBlank(message = "Name required")
	private String name;

	@Email(message = "Invalid e-mail")
	private String email;

	@Size(min = 7, max = 99, message = "Password must de between 7 and 99")
	private String password;

	public Usuario transformToUser() {

		Usuario user = new Usuario(null, this.name, this.email, this.password, null, null);
		return user;

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

}
