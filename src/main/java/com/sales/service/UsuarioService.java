package com.sales.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.domain.Usuario;
import com.sales.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository userRepository;


	public List<Usuario> findAll() {
		return userRepository.findAll();
		}
	
	public Usuario find(Integer id) { 
		 Optional<Usuario> obj = userRepository.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName(), null)); 
		}
	
	
}
