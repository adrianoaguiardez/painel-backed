package br.com.simconsult.painel.modelo;

import java.math.BigDecimal;

public class Painel {

	private Long id;

	private Produto produto;

	private BigDecimal valorMedioRegionalProdImp = BigDecimal.ZERO;

	private BigDecimal precoReferenciaIcms = BigDecimal.ZERO;

	private BigDecimal valorEstimadoIcms = BigDecimal.ZERO;

	private BigDecimal pisPasepConfinsCide = BigDecimal.ZERO;

	private BigDecimal precoComAplicativo = BigDecimal.ZERO;

	private BigDecimal valorDoDescontoAplicativo = BigDecimal.ZERO;

	private BigDecimal precoFinalPosto = BigDecimal.ZERO;

	private String nomeAplicativo;

	@Deprecated
	public Painel() {
		super();
	}

	public Painel(Produto produto, BigDecimal valorMedioRegionalProdImp, BigDecimal precoReferenciaIcms,
			BigDecimal valorEstimadoIcms, BigDecimal pisPasepConfinsCide, BigDecimal precoComAplicativo,
			BigDecimal valorDoDescontoAplicativo, BigDecimal precoFinalPosto, String nomeAplicativo) {

		this.produto = produto;
		this.valorMedioRegionalProdImp = valorMedioRegionalProdImp;
		this.precoReferenciaIcms = precoReferenciaIcms;
		this.valorEstimadoIcms = valorEstimadoIcms;
		this.pisPasepConfinsCide = pisPasepConfinsCide;
		this.precoComAplicativo = precoComAplicativo;
		this.valorDoDescontoAplicativo = valorDoDescontoAplicativo;
		this.precoFinalPosto = precoFinalPosto;
		this.nomeAplicativo = nomeAplicativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getValorMedioRegionalProdImp() {
		return valorMedioRegionalProdImp;
	}

	public void setValorMedioRegionalProdImp(BigDecimal valorMedioRegionalProdImp) {
		this.valorMedioRegionalProdImp = valorMedioRegionalProdImp;
	}

	public BigDecimal getPrecoReferenciaIcms() {
		return precoReferenciaIcms;
	}

	public void setPrecoReferenciaIcms(BigDecimal precoReferenciaIcms) {
		this.precoReferenciaIcms = precoReferenciaIcms;
	}

	public BigDecimal getValorEstimadoIcms() {
		return valorEstimadoIcms;
	}

	public void setValorEstimadoIcms(BigDecimal valorEstimadoIcms) {
		this.valorEstimadoIcms = valorEstimadoIcms;
	}

	public BigDecimal getPisPasepConfinsCide() {
		return pisPasepConfinsCide;
	}

	public void setPisPasepConfinsCide(BigDecimal pisPasepConfinsCide) {
		this.pisPasepConfinsCide = pisPasepConfinsCide;
	}

	public BigDecimal getPrecoComAplicativo() {
		return precoComAplicativo;
	}

	public void setPrecoComAplicativo(BigDecimal precoComAplicativo) {
		this.precoComAplicativo = precoComAplicativo;
	}

	public BigDecimal getValorDoDescontoAplicativo() {
		return precoComAplicativo .subtract(calcularValorFinal());
	}

	public void setValorDoDescontoAplicativo(BigDecimal valorDoDescontoAplicativo) {
		this.valorDoDescontoAplicativo = valorDoDescontoAplicativo;
	}

	public BigDecimal getPrecoFinalPosto() {
		return calcularValorFinal();
	}

	public void setPrecoFinalPosto(BigDecimal precoFinalPosto) {
		this.precoFinalPosto = precoFinalPosto;
	}

	public String getNomeAplicativo() {
		return nomeAplicativo;
	}

	public void setNomeAplicativo(String nomeAplicativo) {
		this.nomeAplicativo = nomeAplicativo;
	}
	
	public BigDecimal calcularValorFinal() {
		return precoFinalPosto.add(valorMedioRegionalProdImp).add(valorEstimadoIcms)
				.add(pisPasepConfinsCide);
	}

}
