package br.com.simconsult.painel.payload.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class ProdutoRequest {

	@NotNull(message = "Selecione um item de combustével")
	private Long id;

	private BigDecimal valorRegionalProdutoImportador;

	private BigDecimal precoAplicativo;

	private BigDecimal precoReferenciaIcms;

	@NotNull(message = "Selecione um grupo de posto")
	private Long codigoGrupoPosto;

	public ProdutoRequest() {

	}

	public ProdutoRequest(Long id, BigDecimal valorRegionalProdutoImportador, BigDecimal precoAplicativo,
			BigDecimal precoReferenciaIcms, Long codigoGrupoPosto) {
		super();
		this.id = id;
		this.valorRegionalProdutoImportador = valorRegionalProdutoImportador;
		this.precoAplicativo = precoAplicativo;
		this.precoReferenciaIcms = precoReferenciaIcms;
		this.codigoGrupoPosto = codigoGrupoPosto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorRegionalProdutoImportador() {
		return valorRegionalProdutoImportador;
	}

	public void setValorRegionalProdutoImportador(BigDecimal valorRegionalProdutoImportador) {
		this.valorRegionalProdutoImportador = valorRegionalProdutoImportador;
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

	public Long getCodigoGrupoPosto() {
		return codigoGrupoPosto;
	}

	public void setCodigoGrupoPosto(Long codigoGrupoPosto) {
		this.codigoGrupoPosto = codigoGrupoPosto;
	}

}
