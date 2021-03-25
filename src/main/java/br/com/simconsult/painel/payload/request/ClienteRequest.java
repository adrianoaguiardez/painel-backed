package br.com.simconsult.painel.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import br.com.simconsult.painel.modelo.TipoPessoa;
import br.com.simconsult.painel.modelo.group.CnpjGroup;
import br.com.simconsult.painel.modelo.group.CpfGroup;
import br.com.simconsult.painel.modelo.group.PessoaClienteRequestGroupSequenceProvider;

@GroupSequenceProvider(PessoaClienteRequestGroupSequenceProvider.class)
public class ClienteRequest {

	private Long id;

	@NotBlank(message = "Nome do cliente é obrigatório")
	private String nome;

	@Size(max = 100, message = "O cpf ou cnpj não pode conter mais de 15 caracteres")
	@CPF(groups = CpfGroup.class, message = "CPF inválido")
	@CNPJ(groups = CnpjGroup.class, message = "CNPJ inválido")
	@NotBlank(message = "Documento do cliente é obrigatório")
	private String document;

	private String telefone;

	@Email(message = "Por favor informar e-mail válido!")
	private String email;

	private TipoPessoa tipoPessoa;

	private String nomeFantasia;

	@NotNull(message = "Selecionar o estado")
	private Long estado;

	@NotNull(message = "Selecionar a cidade ")
	private Long cidade;

	@NotNull(message = "Selecionar o grupo do posto")
	private Long grupoPosto;

	@Deprecated
	public ClienteRequest() {
		super();
	}

	public ClienteRequest(Long id, String nome, String document, String telefone, String email, TipoPessoa tipoPessoa,
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

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Long getCidade() {
		return cidade;
	}

	public void setCidade(Long cidade) {
		this.cidade = cidade;
	}

	public Long getGrupoPosto() {
		return grupoPosto;
	}

	public void setGrupoPosto(Long grupoPosto) {
		this.grupoPosto = grupoPosto;
	}

}
