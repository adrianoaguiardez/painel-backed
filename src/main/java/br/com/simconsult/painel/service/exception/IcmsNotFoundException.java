package br.com.simconsult.painel.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IcmsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IcmsNotFoundException(String message) {
		super();
	}
}
