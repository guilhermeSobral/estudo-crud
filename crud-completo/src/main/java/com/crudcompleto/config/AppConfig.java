package com.crudcompleto.config;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.crudcompleto.entities.Pedido;
import com.crudcompleto.entities.Produto;
import com.crudcompleto.entities.Usuario;
import com.crudcompleto.repositories.PedidoRepository;
import com.crudcompleto.repositories.ProdutoRepository;
import com.crudcompleto.repositories.UsuarioRepository;

@Configuration
@Profile("teste")
public class AppConfig {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Bean
	public void initDB() {
		var usuario = new Usuario("guilhermesbarros13@gmail.com", "123");
		
		var p1 = new Produto("Tv", new BigDecimal(1500.0));
		var p2 = new Produto("Playstation 5", new BigDecimal(4999.0));
		var p3 = new Produto("Celular", new BigDecimal(1000.0));
		var p4 = new Produto("Fone de Ouvido", new BigDecimal(100.0));
		var p5 = new Produto("Teclado", new BigDecimal(150.0));
		
		var pedido1 = new Pedido(p1, usuario);
		pedido1.setProduto(p2);
		pedido1.setProduto(p4);
		pedido1.isAtivo(false);
		
		usuario.setPedidos(pedido1);
		
		usuarioRepository.save(usuario);
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		pedidoRepository.save(pedido1);
	}
}
