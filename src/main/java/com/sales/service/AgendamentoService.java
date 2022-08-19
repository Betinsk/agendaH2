package com.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.domain.Agendamento;
import com.sales.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	AgendamentoRepository agendamentoRepository;
	

	public List<Agendamento> findAll() {
		return agendamentoRepository.findAll();
		}
}
