package com.sales.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sales.DTO.ClienteNewDTO;
import com.sales.domain.Cliente;
import com.sales.service.ClienteService;

@RestController
@RequestMapping(value ="/clientes")	
public class ClienteResource {
	
	
	@Autowired
	private ClienteService clienteService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = clienteService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Method findById
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<Cliente> find(@PathVariable Integer id) {
			Cliente obj = clienteService.find(id);
			return ResponseEntity.ok().body(obj);
		}

		
		//Method post 
				@RequestMapping(method=RequestMethod.POST)
				public ResponseEntity<Void> insert(@RequestBody ClienteNewDTO objDto) {
				Cliente obj = clienteService.fromDTO(objDto);
				obj = clienteService.insert(obj);
					URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
					return ResponseEntity.created(uri).build();
				}
}
