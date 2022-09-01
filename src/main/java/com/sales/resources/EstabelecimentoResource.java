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

import com.sales.domain.Estabelecimento;
import com.sales.service.EstabelecimentoService;

@RestController
@RequestMapping(value = "/Estabelecimentos")
public class EstabelecimentoResource {

	@Autowired	
	private EstabelecimentoService EstabelecimentoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Estabelecimento>> findAll() {
		List<Estabelecimento> list = EstabelecimentoService.findAll();
		return ResponseEntity.ok().body(list);
	}

	// Method findById
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Estabelecimento> find(@PathVariable Integer id) {
		Estabelecimento obj = EstabelecimentoService.find(id);
		return ResponseEntity.ok().body(obj);
	}

	// Method post
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Estabelecimento obj) {
		obj = EstabelecimentoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}