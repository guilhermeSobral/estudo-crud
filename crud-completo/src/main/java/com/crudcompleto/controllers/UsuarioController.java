package com.crudcompleto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crudcompleto.entities.dto.UsuarioDTO;
import com.crudcompleto.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/email")
	public ResponseEntity<UsuarioDTO> findUsuarioByEmail(@RequestParam String email) {
		var usuario = service.searchByEmail(email);
		var dto = new UsuarioDTO(usuario);
		return ResponseEntity.ok().body(dto);
	}

}
