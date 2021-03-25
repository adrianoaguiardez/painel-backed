package br.com.simconsult.painel.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBCIDADE")
public class Cidade {

	@Id
	//@SequenceGenerator(name = "InvSeqCidade", sequenceName = "CIDADE_SEQ", allocationSize = 1, initialValue = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InvSeqCidade")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long codigo;

	@NotNull(message = "O nome é obrigatória")
	@Column(name = "NOME", length = 40)
	private String nome;

	@Column(name = "CT_IBGE", length = 40)
	private int ctIbge;

	@NotNull(message = "O estado é obrigatório")
	@ManyToOne
	@JoinColumn(name = "ID_ESTADO")
	private Estado estado;

	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCtIbge() {
		return ctIbge;
	}

	public void setCtIbge(int ctIbge) {
		this.ctIbge = ctIbge;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	

	public boolean isNovo() {
		return this.codigo == null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
