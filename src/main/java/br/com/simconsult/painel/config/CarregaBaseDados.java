package br.com.simconsult.painel.config;

import java.util.Collections;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@CrossOrigin
@Configuration
public class CarregaBaseDados {

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

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("PATCH");

		source.registerCorsConfiguration("/**", config);
		final FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}
