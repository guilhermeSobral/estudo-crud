package com.crudcompleto.oauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crudcompleto.oauth.clients.UsuarioFeignClient;

@Service
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioFeignClient client;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var usuario = client.findUsuarioByEmail(username).getBody();
		return usuario;
	}

}
