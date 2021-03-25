package br.com.simconsult.painel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simconsult.painel.modelo.ImpostoFederal;

public interface ImpostoFederalRepository extends JpaRepository<ImpostoFederal, Long> {

	//@Query("SELECT i FROM IMPOSTO_FEDERAL i ORDER BY i.id ASC LIMIT 1 ")
	public Optional<ImpostoFederal> findTop1ByOrderById();

	//findTop3ByCompanyOrderByName
}
