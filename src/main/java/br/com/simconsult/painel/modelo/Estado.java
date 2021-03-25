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
@Table(name = "TBESTADO")
public class Estado {
	@Id
	// @SequenceGenerator(name = "InvSeqEstado", sequenceName = "ESTADO_SEQ",
	// allocationSize = 1, initialValue = 1)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "InvSeqEstado")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long codigo;

	@Column(name = "UF", length = 2)
	private String sigla;

	@NotNull(message = "O nome é obrigatória")
	@Column(name = "UF_NOME")
	private String nome;

	@Column(name = "UF_IBGE")
	private int ufIbge;
	
	@Column(name = "UD_DDD")
	private String udDDD;
	

	@Column(name = "UF_DDD", length = 50)
	private String ufDDD;

	@NotNull(message = "O país é obrigatório")
	@ManyToOne
	@JoinColumn(name = "ID_PAIS")
	private Pais pais;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getUfIbge() {
		return ufIbge;
	}

	public void setUfIbge(int ufIbge) {
		this.ufIbge = ufIbge;
	}

	public String getUfDDD() {
		return ufDDD;
	}

	public void setUfDDD(String ufDDD) {
		this.ufDDD = ufDDD;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
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
		Estado other = (Estado) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	// public Pais getPais() {
	// return pais;
	// }
	//
	// public void setPais(Pais pais) {
	// this.pais = pais;
	// }

}
