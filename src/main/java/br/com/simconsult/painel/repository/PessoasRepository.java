package br.com.simconsult.painel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simconsult.painel.modelo.Pessoa;

public interface PessoasRepository  extends JpaRepository<Pessoa, Long>{

}
