package br.com.simconsult.painel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.simconsult.painel.modelo.UsuarioCliente;

@Repository
public interface UserClienteRepository extends JpaRepository<UsuarioCliente, Long> {
	
	List<UsuarioCliente> findAllByClienteCodigo(Long codigo);
	
	List<UsuarioCliente> findAllByUsuarioCodigo(Long codigo);
	
	
	

}
