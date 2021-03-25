package br.com.simconsult.painel.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBPAIS")
public class Pais {

	@Id
	//@SequenceGenerator(name = "InvSeqPais", sequenceName = "PAIS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long codigo;

	@Column(name = "SL_NOME", length = 60)
	private String nome;

	@Column(name = "SL_NOME_PT")
	private String nomePT;

	@Column(name = "SL_SIGLA", length = 2)
	private String UfIbge;

	@Column(name = "SL_BACEN", length = 50)
	private String UfDDD;

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

	public String getNomePT() {
		return nomePT;
	}

	public void setNomePT(String nomePT) {
		this.nomePT = nomePT;
	}

	public String getUfIbge() {
		return UfIbge;
	}

	public void setUfIbge(String ufIbge) {
		UfIbge = ufIbge;
	}

	public String getUfDDD() {
		return UfDDD;
	}

	public void setUfDDD(String ufDDD) {
		UfDDD = ufDDD;
	}

}
