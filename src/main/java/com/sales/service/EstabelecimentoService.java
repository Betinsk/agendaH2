package com.sales.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.domain.Estabelecimento;
import com.sales.domain.Servico;
import com.sales.repositories.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {

	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;

	public List<Estabelecimento> findAll() {
		return estabelecimentoRepository.findAll();
		}

	public Estabelecimento find(Integer id) { 
		 Optional<Estabelecimento> obj = estabelecimentoRepository.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Servico.class.getName(), null)); 
		}

	//Method for insert
		public Estabelecimento insert(Estabelecimento obj) {
			//obj.setId(null);
			estabelecimentoRepository.save(obj); 
			return obj;
		}
}