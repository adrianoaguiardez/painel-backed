package br.com.simconsult.painel.payload.request;

import javax.validation.constraints.NotBlank;

public class GrupoPostoRequest {

	public Long id;
	
	@NotBlank(message = "Descrição do grupo é obrigatório")
	public String descricao;

	public Long codigoCliente;

	@Deprecated
	public GrupoPostoRequest() {

	}

	public GrupoPostoRequest(Long id, String descricao, Long codigoCliente) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigoCliente = codigoCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

}
