package com.sales.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.domain.Agendamento;
import com.sales.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	AgendamentoRepository agendamentoRepository;

	@Autowired
	ServicoService servicoService;

	@Autowired
	ClienteService clienteService;

	@Autowired
	ProfissionalService profissionalService;
	

	public List<Agendamento> findAll() {
		return agendamentoRepository.findAll();
		}
	
	public Agendamento find(Integer id) { 
		 Optional<Agendamento> obj = agendamentoRepository.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Agendamento.class.getName(), null)); 
		}
	
	//Method for insert
	public Agendamento insert(Agendamento objAgendamento) {
		objAgendamento.setId(null);
		objAgendamento.setDate(new Date());
		objAgendamento.setCliente(clienteService.find(objAgendamento.getCliente().getId()));
		objAgendamento.setServico(servicoService.find(objAgendamento.getServico().getId()));
		objAgendamento.setProfissional(profissionalService.find(objAgendamento.getProfissional().getId()));
		objAgendamento = agendamentoRepository.save(objAgendamento);
		return objAgendamento;
	}
}
