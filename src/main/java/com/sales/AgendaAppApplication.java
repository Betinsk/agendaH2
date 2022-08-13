package com.sales;

import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sales.domain.Agendamento;
import com.sales.domain.Cliente;
import com.sales.domain.Endereco;
import com.sales.domain.Estabelecimento;
import com.sales.domain.Profissional;
import com.sales.domain.Servico;

@SpringBootApplication
public class AgendaAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AgendaAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	/*	Endereco endereco = new Endereco(1, "Avenida Brasil" , "RJ", "Rio de Janeiro", "Brasil");
		Endereco endereco2 = new Endereco(2, "Avenida Rio Negro" , "MG", "Contagem", "Brasil");
		System.out.println(endereco);
		
		Cliente cliente = new Cliente(1, "Carlos Alberto", "12215586680", "M", "3199210527", "Gmdust@hotmail.com", endereco);
		System.out.println(cliente);
		
		Estabelecimento estabelecimento = new Estabelecimento(1, "Barbearia", endereco2);
		System.out.println(estabelecimento);
		
		Profissional profissional = new Profissional(1, "Luan Rocha", "1256688987", "Barbeiro", "Luan@Gmail.com", estabelecimento);
		System.out.println(profissional);
		
		Servico servico = new Servico(1, "Corte de cabelo", 30.00, "Corte");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 

		
		Agendamento agendamento = new Agendamento(1, sdf.parse("2022-08-10 10:30"), servico, cliente, profissional);
		System.out.println(agendamento); */

		
		
		
	}

}
