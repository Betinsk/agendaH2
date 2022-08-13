package com.sales.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.DTO.ClienteNewDTO;
import com.sales.domain.Cliente;
import com.sales.domain.Endereco;
import com.sales.repositories.ClienteRepository;
import com.sales.repositories.EnderecoRepository;

@Service	
public class ClienteService {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
		}
	
	public Cliente find(Integer id) { 
		 Optional<Cliente> obj = clienteRepository.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName(), null)); 
		}
	
	//Method for insert
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		enderecoRepository.save(obj.getEndereco());
		obj = clienteRepository.save(obj);
		return obj;
	}

	public Cliente fromDTO(ClienteNewDTO objDto) {
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getEstado(), objDto.getCidade(), objDto.getPais(), objDto.getBairro());
	Cliente cliente = new Cliente(null, objDto.getNome(), objDto.getCpf(), objDto.getSexo(), objDto.getTelefone(), objDto.getEmail(), end);
	cliente.getEndereco();
	return cliente;
	}
}
