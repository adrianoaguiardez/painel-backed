package br.com.simconsult.painel.payload.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ImpostoFederalRequest {

	private Long id;

	@NotBlank(message = "Descrição do icms é obrigatório")
	private String descricao;

	@NotNull(message = "Pis/Pasep é obrigatório")
	private BigDecimal pisPasep;

	@NotNull(message = "Confis é obrigatório")
	private BigDecimal confins;

	@NotNull(message = "Cide  é obrigatório")
	private BigDecimal cide;

	@Deprecated
	public ImpostoFederalRequest() {
		super();
	}

	public ImpostoFederalRequest(Long id, @NotBlank(message = "Descrição do icms é obrigatório") String descricao,
			@NotNull(message = "Pis/Pasep é obrigatório") BigDecimal pisPasep,
			@NotNull(message = "Confis é obrigatório") BigDecimal confins,
			@NotNull(message = "Cide  é obrigatório") BigDecimal cide) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.pisPasep = pisPasep;
		this.confins = confins;
		this.cide = cide;
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

	public BigDecimal getPisPasep() {
		return pisPasep;
	}

	public void setPisPasep(BigDecimal pisPasep) {
		this.pisPasep = pisPasep;
	}

	public BigDecimal getConfins() {
		return confins;
	}

	public void setConfins(BigDecimal confins) {
		this.confins = confins;
	}

	public BigDecimal getCide() {
		return cide;
	}

	public void setCide(BigDecimal cide) {
		this.cide = cide;
	}

}
