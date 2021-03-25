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

@Table
@Entity(name = "TBPRODUTO_CLIENTE")
public class ProdutoCliente {

	@Id
	@SequenceGenerator(name = "InvSeqProdutoCliente", sequenceName = "TBPRODUTO_CLIENTE_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InvSeqProdutoCliente")
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "VALOR_REGIONAL_PRODUTO_IMPORTADOR")
	private BigDecimal valorRegionalProdutoImportador = BigDecimal.ZERO;
	@Column(name = "PRECO_REGIONAL_PRODUTO_IMPORTADOR")
	private BigDecimal precoRegionalProdutoImportador = BigDecimal.ZERO;

	@Column(name = "VALOR_VENDA")
	private BigDecimal valorVenda = BigDecimal.ZERO;

	@Column(name = "PRECO_APLICATIVO")
	private BigDecimal precoAplicativo = BigDecimal.ZERO;

	@Column(name = "PRECO_REFERENCIA_ICMS")
	private BigDecimal precoReferenciaIcms = BigDecimal.ZERO;

	@ManyToOne
	@JoinColumn(name = "CODIGO_PRODUTO")
	private Produto produto;

	@ManyToOne
	@JoinColumn(name = "CODIGO_CLIENTE")
	private Cliente cliente;

	@Column(name = "INCLUSAO", nullable = false)
	private LocalDate inclusao = LocalDate.now();

	@Column(name = "ATIVO")
	private boolean ativo = true;

	@Deprecated
	public ProdutoCliente() {
		super();
	}

	public ProdutoCliente(Long codigo, BigDecimal valorRegionalProdutoImportador,
			BigDecimal precoRegionalProdutoImportador, BigDecimal valorVenda, BigDecimal precoAplicativo,
			BigDecimal precoReferenciaIcms, Produto produto, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.valorRegionalProdutoImportador = valorRegionalProdutoImportador;
		this.precoRegionalProdutoImportador = precoRegionalProdutoImportador;
		this.valorVenda = valorVenda;
		this.precoAplicativo = precoAplicativo;
		this.precoReferenciaIcms = precoReferenciaIcms;
		this.produto = produto;
		this.cliente = cliente;
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValorRegionalProdutoImportador() {
		return valorRegionalProdutoImportador;
	}

	public void setValorRegionalProdutoImportador(BigDecimal valorRegionalProdutoImportador) {
		this.valorRegionalProdutoImportador = valorRegionalProdutoImportador;
	}

	public BigDecimal getPrecoRegionalProdutoImportador() {
		return precoRegionalProdutoImportador;
	}

	public void setPrecoRegionalProdutoImportador(BigDecimal precoRegionalProdutoImportador) {
		this.precoRegionalProdutoImportador = precoRegionalProdutoImportador;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public BigDecimal getPrecoAplicativo() {
		return precoAplicativo;
	}

	public void setPrecoAplicativo(BigDecimal precoAplicativo) {
		this.precoAplicativo = precoAplicativo;
	}

	public BigDecimal getPrecoReferenciaIcms() {
		return precoReferenciaIcms;
	}

	public void setPrecoReferenciaIcms(BigDecimal precoReferenciaIcms) {
		this.precoReferenciaIcms = precoReferenciaIcms;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
