package com.crudcompleto.service;

import org.springframework.stereotype.Service;

import com.crudcompleto.entities.Usuario;
import com.crudcompleto.repositories.UsuarioRepository;

@Service
public class UsuarioService extends GenericService<UsuarioRepository, Usuario, Long> {

	public UsuarioService(UsuarioRepository repository) {
		super(repository, Usuario.class);
	}

}
