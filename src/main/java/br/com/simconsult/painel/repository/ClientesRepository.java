package br.com.simconsult.painel.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simconsult.painel.modelo.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByGrupoPostoId(Long id);
	
	Page<Cliente> findAllByCodigoOrParentCodigo(Long codigo, Long codigoParente, Pageable pageable);
	
	
//	@Query("SELECT c FROM cliente c WHERE c.grupoPosto.id = ?1")
//	public Optional<Cliente> findByPorGrupo(Long codigoGrupo);
	
	
	

}
