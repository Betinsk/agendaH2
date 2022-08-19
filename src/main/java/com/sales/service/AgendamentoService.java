package com.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.domain.Agendamento;
import com.sales.domain.Cliente;
import com.sales.repositories.AgendamentoRepository;
import com.sales.repositories.ClienteRepository;
import com.sales.repositories.EnderecoRepository;
import com.sales.repositories.EstabelecimentoRepository;
import com.sales.repositories.ProfissionalRepository;
import com.sales.repositories.ServicoRepository;

@Service
public class AgendamentoService {

	@Autowired
	AgendamentoRepository agendamentoRepository;
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;
	
	@Autowired
	ProfissionalRepository profissionalRepository;
	

	

	public List<Agendamento> findAll() {
		return agendamentoRepository.findAll();
		}
	
	//Method for insert
	public Agendamento insert(Agendamento obj) {
		//obj.setCliente(clienteService.find(obj.getCliente().getId()));
		obj.setId(null);
		return obj;
	}
}
