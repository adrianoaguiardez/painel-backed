package br.com.simconsult.painel.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.simconsult.painel.modelo.GrupoPosto;
import br.com.simconsult.painel.payload.request.GrupoPostoRequest;
import br.com.simconsult.painel.repository.GrupoPostoRepository;

@Service
public class GrupoPostoService {

	@Autowired
	private GrupoPostoRepository repository;

	public List<GrupoPosto> listaTodas() {

		return repository.findAll();
	}

	public GrupoPosto findById(Long codigo) {
		return repository.findById(codigo).orElseThrow(() -> new EntityNotFoundException());
	}

	public GrupoPosto salvar(GrupoPosto grupoPosto) {

		return repository.save(grupoPosto);

	}

	@Transactional
	public GrupoPosto update(Long id, GrupoPostoRequest grupoPostoRequest) {

		GrupoPosto grupoPostoBanco = getId(id);

		// Cliente cliente =
		// clienteService.getCliente(grupoPostoRequest.getCodigoCliente());
		grupoPostoBanco.setDescricao(grupoPostoRequest.getDescricao());

		return repository.save(grupoPostoBanco);

	}

	public GrupoPosto getId(Long id) {

		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());

	}

	public List<GrupoPosto> listAll() {

		return repository.findAll();
	}

}
