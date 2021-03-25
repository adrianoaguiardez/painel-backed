package br.com.simconsult.painel.payload.reponse;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

public class IcmsResponse {

	private Long id;

	@NotBlank(message = "Descrição do icms é obrigatório")
	private String descricao;

	private BigDecimal porcentagem;

	private Long codigoEstado;

	@Deprecated
	public IcmsResponse() {
		super();
	}

	public IcmsResponse(Long id, @NotBlank(message = "Descrição do icms é obrigatório") String descricao,
			BigDecimal porcentagem, Long codigoEstado) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.porcentagem = porcentagem;
		this.codigoEstado = codigoEstado;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPorcentagem() {
		return porcentagem;
	}

	public Long getCodigoEstado() {
		return codigoEstado;
	}

}
