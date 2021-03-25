package br.com.simconsult.painel.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simconsult.painel.modelo.Cidade;
import br.com.simconsult.painel.repository.CidadesRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadesRepository repository;

	public List<Cidade> listaTodas(Long codigoCidade) {
		
		return repository.findByEstadoCodigo(codigoCidade);
	}
	
	
	public Cidade findById(Long cidade) {
		return repository.findById(cidade).orElseThrow(() -> new EntityNotFoundException());
	}
	
	
	

}
