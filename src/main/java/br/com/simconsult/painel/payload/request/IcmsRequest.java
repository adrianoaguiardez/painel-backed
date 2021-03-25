package br.com.simconsult.painel.payload.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class IcmsRequest {

	private Long id;

	@NotBlank(message = "Descrição do icms é obrigatório")
	private String descricao;

	@NotNull(message = "Porcentagem do icms é obrigatório")
	private BigDecimal porcentagem;

	@NotNull(message = "Selecione um estado")
	private Long codigoEstado;

	@Deprecated
	public IcmsRequest() {
		super();
	}

	public IcmsRequest(Long id, @NotBlank(message = "Descrição do icms é obrigatório") String descricao,
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

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(BigDecimal porcentagem) {
		this.porcentagem = porcentagem;
	}

	public Long getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(Long codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

}
