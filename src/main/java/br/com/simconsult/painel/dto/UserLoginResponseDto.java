package br.com.simconsult.painel.dto;

import java.io.Serializable;


public class UserLoginResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String token;
	private Long expireIn;
	private String tokenProvider;
	public UserLoginResponseDto(String token, Long expireIn, String tokenProvider) {
		super();
		this.token = token;
		this.expireIn = expireIn;
		this.tokenProvider = tokenProvider;
	}
	public String getToken() {
		return token;
	}
	public Long getExpireIn() {
		return expireIn;
	}
	public String getTokenProvider() {
		return tokenProvider;
	}
	
	
	
}
