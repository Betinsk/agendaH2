package com.sales.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.DTO.ProfissionalDTO;
import com.sales.domain.Cliente;
import com.sales.domain.Endereco;
import com.sales.domain.Estabelecimento;
import com.sales.domain.Profissional;
import com.sales.repositories.EnderecoRepository;
import com.sales.repositories.EstabelecimentoRepository;
import com.sales.repositories.ProfissionalRepository;

@Service	
public class ProfissionalService {

	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	
	
	
	public List<Profissional> findAll() {
		return profissionalRepository.findAll();
		}
	
	public Profissional find(Integer id) { 
		 Optional<Profissional> obj = profissionalRepository.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Profissional.class.getName(), null)); 
		}
	
	//Method for insert
	public Profissional insert(Profissional obj) {
		obj.setId(null);
		estabelecimentoRepository.save(obj.getEstabelecimento());
		
		obj = profissionalRepository.save(obj);
		return obj;
	}

	public Profissional fromDTO(ProfissionalDTO objDto) {
	Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getEstado(), objDto.getCidade(), objDto.getPais(), objDto.getBairro());
	enderecoRepository.save(end);
	Estabelecimento est = new Estabelecimento(null, objDto.getTipo(), end);
	estabelecimentoRepository.save(est);
	Profissional pro = new Profissional(null, objDto.getNome(), objDto.getCpf(), objDto.getProfissao(), objDto.getEmail(), est);
	profissionalRepository.save(pro);
	return pro;
	
	}

}
