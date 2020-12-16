package com.crudcompleto.service;

import org.springframework.stereotype.Service;

import com.crudcompleto.controllers.exceptions.ObjetoNaoEncontradoException;
import com.crudcompleto.entities.Usuario;
import com.crudcompleto.repositories.UsuarioRepository;

@Service
public class UsuarioService extends GenericService<UsuarioRepository, Usuario, Long> {

	public UsuarioService(UsuarioRepository repository) {
		super(repository, Usuario.class);
	}
	
	public Usuario searchByEmail(String email) {
		var usuario = filter(usr -> usr.getEmail().equals(email));
		if(usuario.isEmpty())
			throw new ObjetoNaoEncontradoException("");
		return usuario.get(0);
	}

}
