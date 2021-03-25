package br.com.simconsult.painel.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simconsult.painel.modelo.Icms;
import br.com.simconsult.painel.modelo.ImpostoFederal;
import br.com.simconsult.painel.modelo.Painel;
import br.com.simconsult.painel.modelo.ProdutoCliente;
import br.com.simconsult.painel.security.AccessManager;
import br.com.simconsult.painel.service.implementar.CalculoImplementar;

@Service
public class CalcularPainelService {

	@Autowired
	private AccessManager accessManager;

	@Autowired
	private IcmsService icmsService;

	@Autowired
	private ImpostoFederalService impostoFederalService;

	public List<Painel> calcularPainel(List<ProdutoCliente> produtos) {

		Optional<Icms> icms = icmsService
				.getIcmsPorEstado(accessManager.selecionarCliente().getCidade().getEstado().getCodigo());

		CalcularPainel calcularPainel = new CalculoImplementar();

		Optional<ImpostoFederal> impostoFederalExiste = impostoFederalService.buscarImpostoFederal();

		BigDecimal acumuloImposto = impostoFederalExiste.get().getConfins()
				.add(impostoFederalExiste.get().getPisPasep()).add(impostoFederalExiste.get().getCide());

		// cid 10%
		List<Painel> listas = new ArrayList<>();
		produtos.forEach(p -> {
			Painel painel = new Painel(p.getProduto(), p.getValorRegionalProdutoImportador(),
					
					p.getPrecoReferenciaIcms(),
					
					
					calcularPainel.calcularValorEstimadoIcms(p.getValorRegionalProdutoImportador(),
							icms.isPresent() ? icms.get().getPorcentegem() : BigDecimal.ZERO),

					calcularPainel.calcularValorEstimadoIcms(p.getValorRegionalProdutoImportador(), acumuloImposto),

					p.getPrecoAplicativo(),
					BigDecimal.ZERO,
					p.getValorVenda(), "Fidelidade");

			listas.add(painel);

		});
		return listas;

	}

}
