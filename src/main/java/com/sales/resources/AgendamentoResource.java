package com.sales.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	

	//Method findById
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Agendamento> find(@PathVariable Integer id) {
		Agendamento obj = agendamentoService.find(id);
		return ResponseEntity.ok().body(obj);
	}

	//Method post 
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Agendamento objAgendamento) {
		try {
			objAgendamento = agendamentoService.insert(objAgendamento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(objAgendamento.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
