package br.com.simconsult.painel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.simconsult.painel.modelo.ProdutoCliente;

public interface ProdutosClienteRepository extends JpaRepository<ProdutoCliente, Long> {

	public List<ProdutoCliente> findByProdutoIdAndClienteGrupoPostoId( Long codigoProduto,
			Long codigoGrupo);

	public ProdutoCliente findByClienteCodigoAndProdutoId(Long codigoCliente, Long codigoProduto);
	
	public List<ProdutoCliente> findByClienteCodigoOrderByProdutoAsc(Long codigoCliente);

	@Query("SELECT p FROM TBPRODUTO_CLIENTE p WHERE p.cliente.codigo = ?1 ORDER BY p.produto.id ASC ")
	public List<ProdutoCliente> findByClientePorProduto(Long codigo);

}
