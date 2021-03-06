package com.crudcompleto;


import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crudcompleto.entities.Produto;
import com.crudcompleto.service.ProdutoService;


@RunWith(SpringRunner.class)
@SpringBootTest
class CrudCompletoApplicationTests {
	
	@Autowired
	private ProdutoService service;

	@Test
	public void testarCadastroProdutoComSucesso() {
		// cenario
		var produto = new Produto("JUnit", new BigDecimal(0));
		//ação
		produto = service.save(produto);
		//validação
		assertThat(produto).isNotNull();
		assertThat(produto.getId()).isNotNull();
	}

}
