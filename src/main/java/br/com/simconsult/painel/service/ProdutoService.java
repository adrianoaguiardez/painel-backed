package br.com.simconsult.painel.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simconsult.painel.exception.NotFoundException;
import br.com.simconsult.painel.modelo.Cliente;
import br.com.simconsult.painel.modelo.Produto;
import br.com.simconsult.painel.modelo.ProdutoCliente;
import br.com.simconsult.painel.modelo.Tipo;
import br.com.simconsult.painel.payload.request.ProdutoRequest;
import br.com.simconsult.painel.repository.ClientesRepository;
import br.com.simconsult.painel.repository.ProdutosClienteRepository;
import br.com.simconsult.painel.repository.ProdutosRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutosRepository repository;

	@Autowired
	private ProdutosClienteRepository produtoClienteRepository;

	@Autowired
	private ClientesRepository clientesRepository;

	public Produto salvar(Produto produto) {
		return repository.save(produto);
	}

	public List<ProdutoCliente> produtos(Long codigo) {
		return produtoClienteRepository.findByClienteCodigoOrderByProdutoAsc(codigo);

	}

	public List<ProdutoCliente> produtosPorGrupoPosto(Long codigo) {
		List<Cliente> clienteRetorno = clientesRepository.findByGrupoPostoId(codigo);

		if (!clienteRetorno.stream().findFirst().isPresent()) {
			throw new NotFoundException("Não existe cliente cadastrado com esse grupo.");
		}

		return produtoClienteRepository.findByClientePorProduto(clienteRetorno.stream().findFirst().get().getCodigo());

	}

	public void atualizar(Long id, ProdutoRequest produtoRequest) {

		List<Cliente> clientes = clientesRepository.findByGrupoPostoId(produtoRequest.getCodigoGrupoPosto());
		clientes.forEach(c -> {
			ProdutoCliente produtoBanco = produtoClienteRepository.findByClienteCodigoAndProdutoId(c.getCodigo(),
					produtoRequest.getId());
			produtoBanco.setValorRegionalProdutoImportador(produtoRequest.getValorRegionalProdutoImportador());
			produtoBanco.setPrecoAplicativo(produtoRequest.getPrecoAplicativo());
			produtoBanco.setPrecoReferenciaIcms(produtoRequest.getPrecoReferenciaIcms());
			produtoClienteRepository.save(produtoBanco);
		});

	}

	public Produto getProduto(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	public ProdutoCliente getProdutoCliente(Long codigoCliente, Long codigoProduto, Long codigoGrupo) {
		List<ProdutoCliente> listarProdutos = produtoClienteRepository
				.findByProdutoIdAndClienteGrupoPostoId(codigoProduto, codigoGrupo);

		ProdutoCliente produtoBanco = listarProdutos.stream().findAny().get();
		return produtoBanco;
	}

	public Produto getProdutoPorCliente(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	public void cadastroInicialDeProdutos(Cliente clienteSalvo) {

		ProdutoCliente produtoClienteGasolinaComum = new ProdutoCliente(null, BigDecimal.ZERO, BigDecimal.ZERO,
				BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, new Produto(1L, "", Tipo.DIESEL, "Litro"), clienteSalvo);
		produtoClienteRepository.save(produtoClienteGasolinaComum);

		ProdutoCliente produtoClienteGasolinaAditivada = new ProdutoCliente(null, BigDecimal.ZERO, BigDecimal.ZERO,
				BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, new Produto(2L, "", Tipo.DIESEL, "Litro"), clienteSalvo);
		produtoClienteRepository.save(produtoClienteGasolinaAditivada);

		ProdutoCliente produtoClienteGasolinaPremiu = new ProdutoCliente(null, BigDecimal.ZERO, BigDecimal.ZERO,
				BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,  new Produto(3L, "", Tipo.DIESEL, "Litro"), clienteSalvo);
		produtoClienteRepository.save(produtoClienteGasolinaPremiu);

		ProdutoCliente produtoClienteEtanolHidratado = new ProdutoCliente(null, BigDecimal.ZERO, BigDecimal.ZERO,
				BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, new Produto(4L, "", Tipo.DIESEL, "Litro"), clienteSalvo);
		produtoClienteRepository.save(produtoClienteEtanolHidratado);

		ProdutoCliente produtoClienteDieselsDez = new ProdutoCliente(null, BigDecimal.ZERO, BigDecimal.ZERO,
				BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, new Produto(5L, "Diesel 10", Tipo.DIESEL, "Litro"), clienteSalvo);
		produtoClienteRepository.save(produtoClienteDieselsDez);

		ProdutoCliente produtoClienteDieselsQuinhentos = new ProdutoCliente(null, BigDecimal.ZERO, BigDecimal.ZERO,
				BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, new Produto(6L, "", Tipo.DIESEL, "Litro"), clienteSalvo);
		produtoClienteRepository.save(produtoClienteDieselsQuinhentos);

		ProdutoCliente produtoClienteGnv = new ProdutoCliente(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
				BigDecimal.ZERO, BigDecimal.ZERO, new Produto(7L, "", Tipo.DIESEL, "Litro"), clienteSalvo);
		produtoClienteRepository.save(produtoClienteGnv);

	}

}
