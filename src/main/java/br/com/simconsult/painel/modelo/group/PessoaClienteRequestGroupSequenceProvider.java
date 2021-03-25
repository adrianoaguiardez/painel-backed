package br.com.simconsult.painel.modelo.group;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import br.com.simconsult.painel.payload.request.ClienteRequest;

public class PessoaClienteRequestGroupSequenceProvider implements DefaultGroupSequenceProvider<ClienteRequest> {

	@Override
	public List<Class<?>> getValidationGroups(ClienteRequest pessoa) {
		List<Class<?>> grupos = new ArrayList<>();
		grupos.add(ClienteRequest.class);

		if (isPessoaSelecionada(pessoa)) {
			grupos.add(pessoa.getTipoPessoa().getGrupo());
		}

		return grupos;
	}

	private boolean isPessoaSelecionada(ClienteRequest pessoa) {
		return pessoa != null && pessoa.getTipoPessoa() != null;
	}

}
