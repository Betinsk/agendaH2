package com.sales;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sales.domain.Agendamento;
import com.sales.domain.Cliente;
import com.sales.domain.Endereco;
import com.sales.domain.Estabelecimento;
import com.sales.domain.Profissional;
import com.sales.domain.Servico;
import com.sales.domain.Usuario;
import com.sales.repositories.AgendamentoRepository;
import com.sales.repositories.ClienteRepository;
import com.sales.repositories.EnderecoRepository;
import com.sales.repositories.EstabelecimentoRepository;
import com.sales.repositories.ProfissionalRepository;
import com.sales.repositories.ServicoRepository;
import com.sales.repositories.UsuarioRepository;

@SpringBootApplication
public class AgendaAppApplication implements CommandLineRunner {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;
	
	@Autowired
	ProfissionalRepository profissionalRepository;
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	AgendamentoRepository agendamentoRepository;
	
	@Autowired
	UsuarioRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AgendaAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			
		Endereco end = new Endereco(1, "Avenida Brasil" , "RJ", "Rio de Janeiro", "Brasil", "Lapa");
		Endereco end2 = new Endereco(2, "Avenida Rio Negro" , "MG", "Contagem", "Brasil", "Cristo");
		
		enderecoRepository.save(end);
		enderecoRepository.save(end2);
		
		Cliente cli = new Cliente(null, "Carlos Alberto", "12215586680", "M", "3199210527", "Gmdust@hotmail.com", end);
		Cliente cli2 = new Cliente(null, "Eric Jonson", "598489498", "M", "31998899779", "Eric@hotmail.com", end2);
		
		clienteRepository.save(cli);
		clienteRepository.save(cli2);

		Endereco end3 = new Endereco(null, "Avenida Rio Negro 840", "MG", "Contagem", "Brasil", "Riacho");
		
		enderecoRepository.save(end3);
		
		Estabelecimento est = new Estabelecimento(null, "Barbearia", end3);
		
		estabelecimentoRepository.save(est);
	
		Profissional profissional = new Profissional(1, "Luan Rocha", "1256688987", "Barbeiro", "Luan@Gmail.com", est);
		profissionalRepository.save(profissional);
		
		Servico serv1 = new Servico(1, "Corte de cabelo", 30.00, "Corte");
		servicoRepository.save(serv1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 

		
		Agendamento agendamento = new Agendamento(1, sdf.parse("2022-08-10 10:30"), serv1, cli, profissional);
		agendamentoRepository.save(agendamento);
		
		Usuario user = new Usuario(null, "UserAdmin", "12215586680", "Gmdust@hotmail.com", "123456");
		userRepository.save(user);

		
		
		
	}

}
