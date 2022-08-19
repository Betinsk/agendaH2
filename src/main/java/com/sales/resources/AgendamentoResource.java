package com.sales.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.domain.Agendamento;
import com.sales.service.AgendamentoService;

@Controller
@RequestMapping(value ="/agendamentos")	
public class AgendamentoResource {
	
	@Autowired
	AgendamentoService agendamentoService;

	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Agendamento>> findAll() {
		List<Agendamento> list = agendamentoService.findAll();
		return ResponseEntity.ok().body(list);
	}	
	
	
}
