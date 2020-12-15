package com.crudcompleto.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "pedido_produto",
			joinColumns = @JoinColumn(name = "pedido_id"),
			inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produto> produtos = new ArrayList<>();	
	private BigDecimal total;
	
	@Column(columnDefinition = "char(1)")
	private char ativo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;	
	
	public Pedido() {}

	public Pedido(Produto produto, Usuario usuario) {
		this.produtos.add(produto);
		this.usuario = usuario;
		updateTotal();
		isAtivo(true);
	}

	public Long getId() {
		return id;
	}

	public List<Produto> getProdutos() {
		return Collections.unmodifiableList(produtos);
	}

	public BigDecimal getTotal() {		
		return total;
	}
	
	public void setProduto(Produto produto) {
		this.produtos.add(produto);
		updateTotal();
	}
	
	public void isAtivo(boolean ativo) {
		this.ativo = (ativo) ? '1' : '2';
	}	
	
	public boolean getAtivo() {
		return (ativo == '1') ? true : false;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	private void updateTotal() {
		this.total = produtos
				.stream()
				.map(produto -> produto.getPreco())
				.reduce(new BigDecimal(0), (x,y) -> x.add(y));
	}
}
