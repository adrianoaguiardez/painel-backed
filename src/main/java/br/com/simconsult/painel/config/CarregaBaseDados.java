//package br.com.simconsult.painel.config;
//
//import java.time.LocalDate;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import br.com.simconsult.painel.modelo.Cidade;
//import br.com.simconsult.painel.modelo.Cliente;
//import br.com.simconsult.painel.modelo.GrupoPosto;
//import br.com.simconsult.painel.modelo.Pessoa;
//import br.com.simconsult.painel.modelo.Role;
//import br.com.simconsult.painel.modelo.TipoPessoa;
//import br.com.simconsult.painel.modelo.Usuario;
//import br.com.simconsult.painel.repository.GrupoPostoRepository;
//import br.com.simconsult.painel.repository.PessoasRepository;
//import br.com.simconsult.painel.service.CidadeService;
//import br.com.simconsult.painel.service.ClienteService;
//import br.com.simconsult.painel.service.UserService;
//
//@Configuration
//public class CarregaBaseDados {
//
//
//
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private CidadeService cidadeService;
//
//	@Autowired
//	private ClienteService clienteRepository;
//
//	@Autowired
//	private PessoasRepository pessoasRepository;
//
//	@Autowired
//	private GrupoPostoRepository grupoPostoRepository;
//
//	@Bean
//	CommandLineRunner carregaDados() {
//		return args -> {
//
//			Pessoa pessoa = pessoasRepository.save(new Pessoa(null, "Adriano de Aguiar", null, null, "97747572115",
//					"adrianoaguiardez@gmail.com", "(65) 996089465", TipoPessoa.FISICA));
//
//			Cidade cidadeBanco = cidadeService.findById(1383L);
//
//			GrupoPosto grupoSalvo = grupoPostoRepository.save(new GrupoPosto(null, "Centro"));
//
//			Cliente cliente = new Cliente(null, null, "Aguiar", LocalDate.now(), true, pessoa, null, null, cidadeBanco,
//					grupoSalvo, null);
//
//			Cliente clienteSalvo = clienteRepository.salvarMatriz(cliente);
//			Usuario user = new Usuario(null, "Adriano de Aguiar", "adrianoaguiardez@gmail.com", "123",
//					Role.ADMINISTRATOR, clienteSalvo);
//			userService.save(user);
//
//		};
//	}
//
//}
