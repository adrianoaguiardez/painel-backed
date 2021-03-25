package br.com.simconsult.painel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.simconsult.painel.modelo.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Long> {

//	public Produto findByClienteCodigoAndId(Long codigoCliente, Long codigo);
//
//	public List<Produto> findByClienteGrupoPostoId(Long codigo);
//
//	
//
//	public List<Produto> findByClienteCodigo(Long codigo);
//	
//	public List<Produto> findByClienteParentCodigo(Long codigo);

}
