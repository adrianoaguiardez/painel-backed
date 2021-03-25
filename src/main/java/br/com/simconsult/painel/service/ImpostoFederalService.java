package br.com.simconsult.painel.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.simconsult.painel.modelo.ImpostoFederal;
import br.com.simconsult.painel.payload.request.IcmsRequest;
import br.com.simconsult.painel.repository.ImpostoFederalRepository;

@Service
public class ImpostoFederalService {

	@Autowired
	private ImpostoFederalRepository repository;

	@Transactional
	public ImpostoFederal salvar(ImpostoFederal impostoFederal) {

		return repository.save(impostoFederal);
	}

	public List<ImpostoFederal> listAll() {

		return repository.findAll();
	}

	public ImpostoFederal atualizar(Long id, IcmsRequest icmsRequest) {
		ImpostoFederal impostoFederalBanco = getImpostoFederal(id);

		impostoFederalBanco.setDescricao(icmsRequest.getDescricao());
		
		return salvar(impostoFederalBanco);

	}

	public ImpostoFederal getImpostoFederal(Long id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}
	
	public Optional<ImpostoFederal> buscarImpostoFederal() {
		return repository.findTop1ByOrderById();
	}

}
