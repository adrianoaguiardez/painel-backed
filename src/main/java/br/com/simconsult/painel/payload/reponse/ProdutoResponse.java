package br.com.simconsult.painel.payload.reponse;

import java.math.BigDecimal;

public class ProdutoResponse {

	private Long id;

	private String descricao;

	private BigDecimal valorRegionalProdutoImportador;

	private BigDecimal precoAplicativo;

	private BigDecimal precoReferenciaIcms;

	private Long codigoGrupoPosto;

	public ProdutoResponse() {

	}

	public ProdutoResponse(Long id, String descricao, BigDecimal valorRegionalProdutoImportador,
			BigDecimal precoAplicativo, BigDecimal precoReferenciaIcms, Long codigoGrupoPosto) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valorRegionalProdutoImportador = valorRegionalProdutoImportador;
		this.precoAplicativo = precoAplicativo;
		this.precoReferenciaIcms = precoReferenciaIcms;
		this.codigoGrupoPosto = codigoGrupoPosto;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValorRegionalProdutoImportador() {
		return valorRegionalProdutoImportador;
	}

	public BigDecimal getPrecoAplicativo() {
		return precoAplicativo;
	}

	public BigDecimal getPrecoReferenciaIcms() {
		return precoReferenciaIcms;
	}

	public Long getCodigoGrupoPosto() {
		return codigoGrupoPosto;
	}

}
