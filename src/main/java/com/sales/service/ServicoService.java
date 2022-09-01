package com.sales.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.domain.Servico;
import com.sales.repositories.ServicoRepository;

@Service	
public class ServicoService {


	@Autowired
	private ServicoRepository ServicoRepository;


	public List<Servico> findAll() {
		return ServicoRepository.findAll();
		}

	public Servico find(Integer id) { 
		 Optional<Servico> obj = ServicoRepository.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Servico.class.getName(), null)); 
		}

	/*
	//Method for insert
	public Servico insert(Servico obj) {
		obj.setId(null);
		enderecoRepository.save(obj.getEndereco());
		obj = ServicoRepository.save(obj);
		return obj;
	}
	public Servico fromDTO(ServicoNewDTO objDto) {
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getEstado(), objDto.getCidade(), objDto.getPais(), objDto.getBairro());
	Servico Servico = new Servico(null, objDto.getNome(), objDto.getCpf(), objDto.getSexo(), objDto.getTelefone(), objDto.getEmail(), end);
	//Servico.getEndereco();
	return Servico;
	}
	*/
}