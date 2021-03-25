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

import br.com.simconsult.painel.modelo.Estado;
import br.com.simconsult.painel.modelo.Icms;
import br.com.simconsult.painel.payload.reponse.IcmsResponse;
import br.com.simconsult.painel.payload.request.IcmsRequest;
import br.com.simconsult.painel.service.EstadoService;
import br.com.simconsult.painel.service.IcmsService;

@RestController
@RequestMapping("/icms")
public class IcmsController {

	@Autowired
	private IcmsService icmsService;

	@Autowired
	private EstadoService estadoService;

	@GetMapping
	public ResponseEntity<List<Icms>> findAll() {

		List<Icms> pm = icmsService.listAll();
		return ResponseEntity.ok(pm);
	}

	@GetMapping("/{id}")
	public ResponseEntity<IcmsResponse> findById(@PathVariable Long id) {

		Icms icmsRetorno = icmsService.getIcms(id);

		IcmsResponse icmsResponse = new IcmsResponse(icmsRetorno.getId(), icmsRetorno.getDescricao(),
				icmsRetorno.getPorcentegem(), icmsRetorno.getEstado().getCodigo());

		return ResponseEntity.ok(icmsResponse);
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody @Valid IcmsRequest icmsRequest) {

		Estado estadoBanco = estadoService.findById(icmsRequest.getCodigoEstado());

		Icms icms = new Icms(null, icmsRequest.getDescricao(), icmsRequest.getPorcentagem(), estadoBanco);
		Icms icmsBanco = icmsService.salvar(icms);

		return ResponseEntity.status(HttpStatus.CREATED).body(icmsBanco);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody IcmsRequest icmsRequest) {

		Icms icms = icmsService.atualizar(id, icmsRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(icms);
	}

}
