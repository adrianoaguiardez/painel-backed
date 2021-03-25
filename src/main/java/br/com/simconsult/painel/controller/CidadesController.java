package br.com.simconsult.painel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.simconsult.painel.modelo.Cidade;
import br.com.simconsult.painel.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadesController {

	@Autowired
	private CidadeService cidadeService;

	@GetMapping("/{codigoCidade}")
	public ResponseEntity<List<Cidade>> findAll(@PathVariable Long codigoCidade) {
		
		List<Cidade> cidades = cidadeService.listaTodas(codigoCidade);
		return ResponseEntity.ok(cidades);
	}

}
