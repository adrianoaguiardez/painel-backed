package br.com.simconsult.painel.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table
@Entity(name = "TBIMPOSTO_FEDERAL")
public class ImpostoFederal {
	@Id
	@SequenceGenerator(name = "InvSeqImpostoFederal", sequenceName = "TBIMPOSTO_FEDERAL_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InvSeqImpostoFederal")
	@Column(name = "CODIGO")
	private Long id;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "PIS_PASEP")
	private BigDecimal pisPasep;

	@Column(name = "CONFINS")
	private BigDecimal confins;

	@Column(name = "CIDE")
	private BigDecimal cide;

	@Column(name = "INCLUSAO", nullable = false)
	private LocalDate inclusao = LocalDate.now();

	@Column(name = "ATIVO")
	private boolean ativo = true;

	@Deprecated
	public ImpostoFederal() {

	}

	public ImpostoFederal(Long id, String descricao, BigDecimal pisPasep, BigDecimal confins, BigDecimal cide) {
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

	public LocalDate getInclusao() {
		return inclusao;
	}

	public void setInclusao(LocalDate inclusao) {
		this.inclusao = inclusao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
