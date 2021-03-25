package br.com.simconsult.painel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simconsult.painel.modelo.Estado;

public interface EstadosRepository extends JpaRepository<Estado, Long> {

}
