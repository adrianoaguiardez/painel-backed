package br.com.simconsult.painel.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.simconsult.painel.service.util.BigDecimalFormatter;

@Table
@Entity(name = "TBICMS")
public class Icms {
	@Id
	@SequenceGenerator(name = "InvSeqIcms", sequenceName = "TBICMS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InvSeqIcms")
	@Column(name = "CODIGO")
	private Long id;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "PORCENTAGEM")
	private BigDecimal porcentegem;

	@ManyToOne
	@JoinColumn(name = "CODIGO_ESTADO")
	private Estado estado;

	@Column(name = "INCLUSAO", nullable = false)
	private LocalDate inclusao = LocalDate.now();

	@Column(name = "ATIVO")
	private boolean ativo = true;

	@Deprecated
	public Icms() {

	}

	public Icms(Long id, String descricao, BigDecimal porcentegem, Estado estado) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.porcentegem = porcentegem;
		this.estado = estado;
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

	public BigDecimal getPorcentegem() {
		return BigDecimalFormatter.normalizaBigDecimalReaisDuasCasa(porcentegem);
	}

	public void setPorcentegem(BigDecimal porcentegem) {
		this.porcentegem = porcentegem;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
