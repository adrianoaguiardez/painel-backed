package br.com.simconsult.painel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simconsult.painel.modelo.Icms;

public interface IcmsRepository extends JpaRepository<Icms, Long> {

	public Optional<Icms> findByEstadoCodigo(Long codigo);

}
