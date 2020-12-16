package com.crudcompleto.entities.dto;

import java.io.Serializable;
import java.util.Set;

import com.crudcompleto.entities.Role;
import com.crudcompleto.entities.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String senha;
	private Set<Role> roles;
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.roles = usuario.getRole();
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public Set<Role> getRoles() {
		return roles;
	}
}
