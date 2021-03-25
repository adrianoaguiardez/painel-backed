package br.com.simconsult.painel.payload.reponse;

public class GrupoPostoResponse {

	public Long id;

	public String descricao;

	public Long codigoCliente;

	@Deprecated
	public GrupoPostoResponse() {

	}

	public GrupoPostoResponse(Long id, String descricao, Long codigoCliente) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigoCliente = codigoCliente;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Long getCodigoCliente() {
		return codigoCliente;
	}

}
