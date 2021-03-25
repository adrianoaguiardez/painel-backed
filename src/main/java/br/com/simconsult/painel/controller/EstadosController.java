package br.com.simconsult.painel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.simconsult.painel.modelo.Estado;
import br.com.simconsult.painel.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadosController {

	@Autowired
	private EstadoService estadoService;
	
	
	@GetMapping
	public ResponseEntity<List<Estado>> listasTodos() {

		List<Estado> estados = estadoService.listarTodos();
		return ResponseEntity.ok(estados);
	}
}
