package br.com.simconsult.painel.payload.reponse;

public class UserResponse {

	private Long id;

	private String name;

	private String email;

	private String password;

	private String confirmPassword;

	private boolean admin = false;
	
	@Deprecated
	public UserResponse() {

	}

	public UserResponse(Long id, String name, String email, String password, String confirmPassword, boolean admin) {
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

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public boolean isAdmin() {
		return admin;
	}

}
