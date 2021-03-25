package br.com.simconsult.painel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.simconsult.painel.modelo.ProdutoCliente;
import br.com.simconsult.painel.payload.reponse.ProdutoResponse;
import br.com.simconsult.painel.payload.request.ProdutoRequest;
import br.com.simconsult.painel.security.AccessManager;
import br.com.simconsult.painel.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoslController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private AccessManager accessManager;

	@GetMapping("/porGrupo/{codigo}")
	public ResponseEntity<List<ProdutoCliente>> findAll(@PathVariable Long codigo) {

		List<ProdutoCliente> produtos = produtoService.produtosPorGrupoPosto(codigo);

		return ResponseEntity.ok(produtos);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> salvar(@PathVariable Long id, @RequestBody ProdutoRequest produtoRequest) {

		produtoService.atualizar(id, produtoRequest);

		return ResponseEntity.ok("");
	}

	@GetMapping("/{id}/grupo/{codigo}")
	public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id, @PathVariable Long codigo) {

		ProdutoCliente produtoRetorno = produtoService.getProdutoCliente(accessManager.usuario().getCodigo(), id, codigo);

		ProdutoResponse produtoResponse = new ProdutoResponse(produtoRetorno.getProduto().getId(),
				produtoRetorno.getProduto().getDescricao(), produtoRetorno.getValorRegionalProdutoImportador(),
				produtoRetorno.getPrecoAplicativo(), produtoRetorno.getPrecoReferenciaIcms(),

				null);

		return ResponseEntity.ok(produtoResponse);
	}

}
