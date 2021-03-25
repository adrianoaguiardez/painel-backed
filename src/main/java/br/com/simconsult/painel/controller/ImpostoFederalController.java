package br.com.simconsult.painel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.simconsult.painel.modelo.ImpostoFederal;
import br.com.simconsult.painel.payload.reponse.ImpostoFederalResponse;
import br.com.simconsult.painel.payload.request.IcmsRequest;
import br.com.simconsult.painel.payload.request.ImpostoFederalRequest;
import br.com.simconsult.painel.service.ImpostoFederalService;

@RestController
@RequestMapping("/impostos")
public class ImpostoFederalController {

	@Autowired
	private ImpostoFederalService impostoFederalService;

	@GetMapping
	public ResponseEntity<List<ImpostoFederal>> findAll() {

		List<ImpostoFederal> pm = impostoFederalService.listAll();
		return ResponseEntity.ok(pm);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ImpostoFederalResponse> findById(@PathVariable Long id) {

		ImpostoFederal impostoFederalRetorno = impostoFederalService.getImpostoFederal(id);

		ImpostoFederalResponse impostoResponse = new ImpostoFederalResponse(impostoFederalRetorno.getId(),
				impostoFederalRetorno.getDescricao(), impostoFederalRetorno.getPisPasep(),
				impostoFederalRetorno.getConfins(), impostoFederalRetorno.getCide());

		return ResponseEntity.ok(impostoResponse);
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody @Valid ImpostoFederalRequest ImpostoFederalRequest) {

		ImpostoFederal impostoFederal = new ImpostoFederal(null, ImpostoFederalRequest.getDescricao(),
				ImpostoFederalRequest.getPisPasep(), ImpostoFederalRequest.getConfins(),
				ImpostoFederalRequest.getCide());
		ImpostoFederal impostoBanco = impostoFederalService.salvar(impostoFederal);

		return ResponseEntity.status(HttpStatus.CREATED).body(impostoBanco);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody IcmsRequest icmsRequest) {

		ImpostoFederal impostoFederal = impostoFederalService.atualizar(id, icmsRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(impostoFederal);
	}

}
