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

import com.sales.DTO.ProfissionalDTO;
import com.sales.domain.Profissional;
import com.sales.service.ProfissionalService;

@RestController
@RequestMapping(value ="/profissionais")	
public class ProfissionalResource {
	
	
	@Autowired
	private ProfissionalService profissionalService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Profissional>> findAll() {
		List<Profissional> list = profissionalService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//Method findById
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<Profissional> find(@PathVariable Integer id) {
			Profissional obj = profissionalService.find(id);
			return ResponseEntity.ok().body(obj);
		}

		
		//Method post dtoSolo
				@RequestMapping(value="/profissional", method=RequestMethod.POST)
				public ResponseEntity<Void> insert(@RequestBody Profissional obj) {
				obj = profissionalService.insert(obj);

					URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
					return ResponseEntity.created(uri).build();
				}
		
		//Method post dto
				@RequestMapping(method=RequestMethod.POST)
				public ResponseEntity<Void> insert(@RequestBody ProfissionalDTO objDto) {
				Profissional obj = profissionalService.fromDTO(objDto);
				obj = profissionalService.insert(obj);
			
					URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
					return ResponseEntity.created(uri).build();
				}
}
