package br.com.simconsult.painel.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TBGRUPO_POSTO")
public class GrupoPosto {

	@Id
	@SequenceGenerator(name = "InvSeqGrupoPosto", sequenceName = "TBGRUPO_POSTO_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InvSeqGrupoPosto")
	@Column(name = "CODIGO")
	private Long id;

	@Column(name = "DESCRICAO")
	@Size(max = 60, message = "A descrição pode conter até 60 caracteres")
	private String descricao;

	@Column(name = "INCLUSAO", nullable = false)
	private LocalDate inclusao = LocalDate.now();

	@Column(name = "ATIVO")
	private boolean ativo = true;

	@Deprecated
	public GrupoPosto() {

	}

	public GrupoPosto(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;

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
