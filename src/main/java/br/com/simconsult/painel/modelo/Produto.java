package br.com.simconsult.painel.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table
@Entity(name = "tbproduto")
public class Produto {

	@Id
	@SequenceGenerator(name = "InvSeqProduto", sequenceName = "TBPRODUTO_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InvSeqProduto")
	@Column(name = "codigo")
	private Long id;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "TIPO")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	@Column(name = "unidade")
	private String unidade;

	@Column(name = "INCLUSAO", nullable = false)
	private LocalDate inclusao = LocalDate.now();

	@Column(name = "ATIVO")
	private boolean ativo = true;

	@Deprecated
	public Produto() {
		super();
	}

	public Produto(Long id, String descricao, Tipo tipo, String unidade) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.tipo = tipo;
		this.unidade = unidade;

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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
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
