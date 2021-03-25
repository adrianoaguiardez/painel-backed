package br.com.simconsult.painel.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import br.com.simconsult.painel.modelo.group.CnpjGroup;
import br.com.simconsult.painel.modelo.group.CpfGroup;
import br.com.simconsult.painel.modelo.group.PessoaClienteGroupSequenceProvider;

@Entity
@Table(name = "tbpessoa")
@GroupSequenceProvider(PessoaClienteGroupSequenceProvider.class)
public class Pessoa {

	@Id
	@SequenceGenerator(name = "InvSeqPessoa", sequenceName = "TBPESSOA_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InvSeqPessoa")
	@Column(name = "CODIGO")
	private Long codigo;

	@NotEmpty(message = "O nome é obrigatória")
	@Size(max = 100, message = "A descrição não pode conter mais de 60 caracteres")
	@Column(name = "NOME")
	private String nome;

	@Column(name = "RG")
	private String rg;

	@Column(name = "DATA_NASCIMENTO")
	private LocalDate dataNascimento;

	@NotEmpty(message = "O cpf ou cnpj é obrigatório")
	@Size(max = 100, message = "O cpf ou cnpj não pode conter mais de 15 caracteres")
	@CPF(groups = CpfGroup.class)
	@CNPJ(groups = CnpjGroup.class)
	@Column(name = "CPF_CNPJ", unique = true)
	private String document;

	@Email(message = "Por favor informar e-mail válido!")
	@Column(name = "EMAIL", unique = true)
	private String email;

	@Size(max = 16, message = "O telefone não pode conter mais de 16 caracteres")
	@Column(name = "TELEFONE", unique = true)
	private String telefone;

	@NotNull(message = "Tipo pessoa é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_PESSOA")
	private TipoPessoa tipoPessoa = TipoPessoa.FISICA;

	@Deprecated
	public Pessoa() {
		super();
	}

	public Pessoa(Long codigo,
			@NotEmpty(message = "O nome é obrigatória") @Size(max = 100, message = "A descrição não pode conter mais de 60 caracteres") String nome,
			String rg, LocalDate dataNascimento,
			@NotEmpty(message = "O cpf ou cnpj é obrigatório") @Size(max = 100, message = "O cpf ou cnpj não pode conter mais de 15 caracteres") @CPF(groups = CpfGroup.class) @CNPJ(groups = CnpjGroup.class) String document,
			@Email(message = "Por favor informar e-mail válido!") String email,
			@Size(max = 16, message = "O telefone não pode conter mais de 16 caracteres") String telefone,
			@NotNull(message = "Tipo pessoa é obrigatório") TipoPessoa tipoPessoa) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.document = document;
		this.email = email;
		this.telefone = telefone;
		this.tipoPessoa = tipoPessoa;
	}
	
	@PrePersist
	@PreUpdate
	private void prePersistPreUpdate() {

		if (this.document != null) {
			this.document = TipoPessoa.removerFormatacao(this.document);
		}
		this.nome = nome.toUpperCase();

	}

	@PostLoad
	private void postLoad() {
		if (this.document != null) {
			this.document = this.tipoPessoa.formatar(this.document);
		}
	}

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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

}