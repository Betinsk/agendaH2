package com.sales.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.domain.Usuario;
import com.sales.service.UsuarioService;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	UsuarioService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}

	// Method findById
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id) {
		Usuario obj = userService.find(id);
		return ResponseEntity.ok().body(obj);
	}

/*	// Method post
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Usuario objUsuario) {
		objUsuario = userService.insert(objUsuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objUsuario.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	} */
}
