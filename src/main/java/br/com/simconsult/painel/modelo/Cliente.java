package br.com.simconsult.painel.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbcliente")
public class Cliente {

	@Id
	@SequenceGenerator(name = "InvSeqCliente", sequenceName = "TBCLIENTE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InvSeqCliente")
	@Column(name = "CODIGO")
	private Long codigo;

	// @NotEmpty(message = "A Inscrição Municipal é obrigatória")
	@Size(max = 20, message = "A Inscrição estadual não pode conter mais de 20 caracteres")
	@Column(name = "INSCRICAO_ESTADUAL")
	private String inscricaoEstadual;

	// @NotEmpty(message = "O Nome Fantasia é obrigatória")
	@Size(max = 250, message = "O Nome Fantasia não pode conter mais de 250 caracteres")
	@Column(name = "NOME_FANTASIA")
	private String nomeFantasia;

	@Column(name = "INCLUSAO", nullable = false)
	private LocalDate inclusao = LocalDate.now();

	@Column(name = "ATIVO")
	private boolean ativo = true;

	@ManyToOne
	@JoinColumn(name = "CODIGO_GRUPO_POSTO")
	private GrupoPosto grupoPosto;

	@ManyToOne
	@JoinColumn(name = "CODIGO_CIDADE")
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(name = "CODIGO_PESSOA", nullable = false)
	@Valid
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "CODIGO_CLIENTE")
	private Cliente parent;

	@JsonIgnore
	@OneToMany(mappedBy = "parent")
	private List<Cliente> parentPai;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "CODIGO_USUARIO_CADASTRO")
	private Usuario usuarioCadastro;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "CODIGO_USUARIO_ALTERAR")
	private Usuario usuarioAlterar;

	public Cliente() {
		super();
	}

	public Cliente(Long codigo,
			@Size(max = 20, message = "A Inscrição estadual não pode conter mais de 20 caracteres") String inscricaoEstadual,
			@Size(max = 250, message = "O Nome Fantasia não pode conter mais de 250 caracteres") String nomeFantasia,
			LocalDate inclusao, boolean ativo, @Valid Pessoa pessoa, Usuario usuarioCadastro, Usuario usuarioAlterar,
			Cidade cidade, GrupoPosto grupoPosto, Cliente parent) {
		super();
		this.codigo = codigo;
		this.inscricaoEstadual = inscricaoEstadual;
		this.nomeFantasia = nomeFantasia;
		this.inclusao = inclusao;
		this.ativo = ativo;
		this.pessoa = pessoa;
		this.usuarioCadastro = usuarioCadastro;
		this.usuarioAlterar = usuarioAlterar;
		this.cidade = cidade;
		this.grupoPosto = grupoPosto;
		this.parent = parent;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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

	public GrupoPosto getGrupoPosto() {
		return grupoPosto;
	}

	public void setGrupoPosto(GrupoPosto grupoPosto) {
		this.grupoPosto = grupoPosto;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Usuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public Usuario getUsuarioAlterar() {
		return usuarioAlterar;
	}

	public void setUsuarioAlterar(Usuario usuarioAlterar) {
		this.usuarioAlterar = usuarioAlterar;
	}

	public Cliente getParent() {
		return parent;
	}

	public void setParent(Cliente parent) {
		this.parent = parent;
	}

	public List<Cliente> getParentPai() {
		return parentPai;
	}

	public void setParentPai(List<Cliente> parentPai) {
		this.parentPai = parentPai;
	}

}