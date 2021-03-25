package br.com.simconsult.painel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simconsult.painel.modelo.Cidade;

public interface CidadesRepository extends JpaRepository<Cidade, Long> {
	
	public List<Cidade> findByEstadoCodigo(Long codigo);

}
