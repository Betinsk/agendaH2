package com.sales.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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
	
	public int converterDateToInt(Agendamento objAgendamento) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(objAgendamento.getDate());
		int c_day = cal.get(Calendar.DAY_OF_MONTH);
		
		return c_day;
		
	}
	
	
public int converterHourToInt(Agendamento objAgendamento) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(objAgendamento.getDate());
		int c_hour = cal.get(Calendar.HOUR);
		
		return c_hour;
		
	}
	
	
	//Method for insert
	public Agendamento insert(Agendamento objAgendamento) throws Exception {
		objAgendamento.setId(null);
		objAgendamento.setCliente(clienteService.find(objAgendamento.getCliente().getId()));
		objAgendamento.setServico(servicoService.find(objAgendamento.getServico().getId()));
		objAgendamento.setProfissional(profissionalService.find(objAgendamento.getProfissional().getId()));
		
		List<Agendamento> list = agendamentoRepository.findAll();
		for (Agendamento x : list) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(x.getDate());
			System.out.println(x.getDate());
			int c_day = cal.get(Calendar.DAY_OF_MONTH);
			int c_hour = cal.get(Calendar.HOUR);
			System.out.println(c_hour);


			if(converterDateToInt(objAgendamento) == c_day && converterHourToInt(objAgendamento)== c_hour) {
				throw new Exception("Já possui essa data e horario");
			}
		}
		
		objAgendamento = agendamentoRepository.save(objAgendamento);
		return objAgendamento;
	}
}
