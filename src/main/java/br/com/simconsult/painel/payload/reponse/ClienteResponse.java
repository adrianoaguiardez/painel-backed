package br.com.simconsult.painel.payload.reponse;

import br.com.simconsult.painel.modelo.TipoPessoa;

public class ClienteResponse {
	private Long id;

	private String nome;

	private String document;

	private String telefone;

	private String email;

	private TipoPessoa tipoPessoa;

	private String nomeFantasia;

	private Long estado;

	private Long cidade;

	private Long grupoPosto;

	@Deprecated
	public ClienteResponse() {
		super();
	}

	public ClienteResponse(Long id, String nome, String document, String telefone, String email, TipoPessoa tipoPessoa,
			String nomeFantasia, Long estado, Long cidade, Long grupoPosto) {
		super();
		this.id = id;
		this.nome = nome;
		this.document = document;
		this.telefone = telefone;
		this.email = email;
		this.tipoPessoa = tipoPessoa;
		this.nomeFantasia = nomeFantasia;
		this.estado = estado;
		this.cidade = cidade;
		this.grupoPosto = grupoPosto;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDocument() {
		return document;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public Long getEstado() {
		return estado;
	}

	public Long getCidade() {
		return cidade;
	}

	public Long getGrupoPosto() {
		return grupoPosto;
	}

}
