package com.crudcompleto.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crudcompleto.oauth.entities.UsuarioDTO;



@Component
@FeignClient(name = "crud", url = "http://localhost:8080", path = "/usuarios")
public interface UsuarioFeignClient {
	
	@GetMapping("/email")
	public ResponseEntity<UsuarioDTO> findUsuarioByEmail(@RequestParam String email);

}
