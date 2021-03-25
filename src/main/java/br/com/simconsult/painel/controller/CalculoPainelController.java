package br.com.simconsult.painel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.simconsult.painel.modelo.Painel;
import br.com.simconsult.painel.modelo.ProdutoCliente;
import br.com.simconsult.painel.security.AccessManager;
import br.com.simconsult.painel.service.CalcularPainelService;
import br.com.simconsult.painel.service.ProdutoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/painel")
public class CalculoPainelController {

	@Autowired
	private CalcularPainelService calcularPainelService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private AccessManager accessManager;

	@GetMapping
	public ResponseEntity<List<Painel>> calculos() {

		List<ProdutoCliente> produtos = produtoService.produtos(accessManager.usuario().getCliente().getCodigo());

		List<Painel> calcularPainel = calcularPainelService.calcularPainel(produtos);

		return ResponseEntity.ok(calcularPainel);
	}

}
