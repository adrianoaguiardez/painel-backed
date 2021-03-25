package br.com.simconsult.painel.service;

import java.math.BigDecimal;


public interface CalcularPainel {
	
	public BigDecimal calcularValorEstimadoIcms(BigDecimal valorMedioProdutoImportador, BigDecimal porcentagemIcms);
	
	
	public BigDecimal calculoDiferencaDoAplicativo(BigDecimal valorVenda, BigDecimal valorAplicativo);
	
	

}
