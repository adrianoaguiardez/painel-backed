package br.com.simconsult.painel.service.implementar;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.simconsult.painel.service.CalcularPainel;

@Component
public class CalculoImplementar implements CalcularPainel {

	@Override
	public BigDecimal calcularValorEstimadoIcms(BigDecimal valorMedioProdutoImportador, BigDecimal porcentagemIcms) {
		
		return valorMedioProdutoImportador.multiply(porcentagemIcms.divide(new BigDecimal("100")));
	}

	@Override
	public BigDecimal calculoDiferencaDoAplicativo(BigDecimal valorVenda, BigDecimal valorAplicativo) {
		
		return valorAplicativo.subtract(valorVenda);
	}

}
