package com.crudcompleto.repositories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProdutoRepositoryTest {
	
	@Autowired
	private ProdutoRepository repository;	

	@Test
	public void testFindProduto() {
		var produto = repository.findById(1L).get();
		Assert.assertNotNull(produto);
	}

}