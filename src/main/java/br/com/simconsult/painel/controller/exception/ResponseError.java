package br.com.simconsult.painel.controller.exception;

import java.util.List;

public class ResponseError {

	List<String> erros;

	public ResponseError(List<String> erros) {
		super();
		this.erros = erros;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

}
