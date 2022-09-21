package com.sales.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


@Service
public class DBService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private UsuarioRepository userRepository;

	public void instantiateTestDatabase() throws ParseException {
		
		Endereco end = new Endereco(null, "Avenida Brasil" , "RJ", "Rio de Janeiro", "Brasil", "Lapa");
		Endereco end2 = new Endereco(null , "Avenida Rio Negro" , "MG", "Contagem", "Brasil", "Cristo");
		Endereco end3 = new Endereco(null, "Avenida Rio Negro 840", "MG", "Contagem", "Brasil", "Riacho");
		Endereco end4 = new Endereco(null, "Rua Guarapari" , "ES", "VILA VELHA", "Brasil", "Morro da Praia");
		
		enderecoRepository.save(end);
		enderecoRepository.save(end2);
		enderecoRepository.save(end3);
		enderecoRepository.save(end4);
		
		Cliente cli = new Cliente(null, "Carlos Alberto", "12215586680", "M", "3199210527", "Gmdust@hotmail.com", end);
		Cliente cli2 = new Cliente(null, "Eric Jonson", "598489498", "M", "31998899779", "Eric@hotmail.com", end2);
		Cliente cli3 = new Cliente(null, "Ryan Carvalho", "12215588447", "M", "33987987", "Ryan@hotmail.com", end4);
	
		
		clienteRepository.save(cli);
		clienteRepository.save(cli2);
		clienteRepository.save(cli3);

		Estabelecimento est = new Estabelecimento(null, "Barbearia", end3);
		estabelecimentoRepository.save(est);
	
		Profissional profissional = new Profissional(1, "Luan Rocha", "1256688987", "Barbeiro", "Luan@Gmail.com", est);
		profissionalRepository.save(profissional);
		
		Servico serv1 = new Servico(1, "Corte de cabelo", 30.00, "Corte");
		Servico serv2 = new Servico(null, "Luzes no cabelo", 70.00, "Luzes");
		servicoRepository.save(serv1);
		servicoRepository.save(serv2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 

		
		Agendamento agendamento = new Agendamento(null, sdf.parse("2022-08-10 10:30"), serv1, cli, profissional);
		Agendamento agendamento2 = new Agendamento(null, sdf.parse("2022-08-10 10:30"), serv2, cli3, profissional);
		Agendamento agendamento3 = new Agendamento(null, sdf.parse("2022-08-10 10:30"), serv2, cli3, profissional);


		agendamentoRepository.save(agendamento);
		agendamentoRepository.save(agendamento2);
		agendamentoRepository.save(agendamento3);

		
		Usuario user = new Usuario(null, "UserAdmin", "12215586680", "Gmdust@hotmail.com", "123456");
		userRepository.save(user);
		
	}

}
