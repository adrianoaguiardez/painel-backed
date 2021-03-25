package br.com.simconsult.painel.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.simconsult.painel.exception.NotFoundException;
import br.com.simconsult.painel.modelo.Icms;
import br.com.simconsult.painel.payload.request.IcmsRequest;
import br.com.simconsult.painel.repository.IcmsRepository;

@Service
public class IcmsService {

	@Autowired
	private IcmsRepository repository;

	@Transactional
	public Icms salvar(Icms icms) {

		if (icms.getId() == null) {
			Optional<Icms> existIcms = getIcmsPorEstado(icms.getEstado().getCodigo());

			if (existIcms.isPresent()) {
				throw new NotFoundException("Já existe icms para o Estado: " + existIcms.get().getEstado().getNome());
			}
		}

		return repository.save(icms);
	}

	public List<Icms> listAll() {

		return repository.findAll();
	}

	public Icms atualizar(Long id, IcmsRequest icmsRequest) {
		Icms icmsBanco = getIcms(id);

		icmsBanco.setDescricao(icmsRequest.getDescricao());
		icmsBanco.setPorcentegem(icmsRequest.getPorcentagem());
		return salvar(icmsBanco);

	}

	public Icms getIcms(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	public Optional<Icms> getIcmsPorEstado(Long id) {
		return repository.findByEstadoCodigo(id);
	}

}
