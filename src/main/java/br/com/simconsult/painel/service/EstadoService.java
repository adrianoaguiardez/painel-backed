package br.com.simconsult.painel.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simconsult.painel.modelo.Estado;
import br.com.simconsult.painel.repository.EstadosRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadosRepository repository;
	
	public List<Estado> listarTodos(){
		return repository.findAll();
	}
	
	public Estado findById(Long estado) {
		return repository.findById(estado).orElseThrow(() -> new EntityNotFoundException());
	}
	
}
