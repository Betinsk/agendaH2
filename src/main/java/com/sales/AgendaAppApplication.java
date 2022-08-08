package com.sales;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sales.domain.Cliente;
import com.sales.domain.Endereco;

@SpringBootApplication
public class AgendaAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AgendaAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Endereco endereco = new Endereco(1, "Avenida Brasil" , "RJ", "Rio de Janeiro", "Brasil");
		System.out.println(endereco);
		
		Cliente cliente = new Cliente(1, "Carlos Alberto", "12215586680", "M", "3199210527", "Gmdust@hotmail.com", endereco);
		System.out.println(cliente);
	}

}
