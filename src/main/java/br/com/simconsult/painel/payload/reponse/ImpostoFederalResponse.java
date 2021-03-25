package br.com.simconsult.painel.payload.reponse;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ImpostoFederalResponse {

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
	public ImpostoFederalResponse() {
		super();
	}

	public ImpostoFederalResponse(Long id, @NotBlank(message = "Descrição do icms é obrigatório") String descricao,
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

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPisPasep() {
		return pisPasep;
	}

	public BigDecimal getConfins() {
		return confins;
	}

	public BigDecimal getCide() {
		return cide;
	}

}
