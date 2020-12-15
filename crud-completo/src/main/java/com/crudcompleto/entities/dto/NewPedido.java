package com.crudcompleto.entities.dto;

import java.io.Serializable;

public class NewPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long idUsuario;
	private Long idProduto;
	private Long unidades;
	
	public NewPedido(Long idUsuario, Long idProduto, Long unidades) {
		this.idUsuario = idUsuario;
		this.idProduto = idProduto;
		this.unidades = unidades;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public Long getUnidades() {
		return unidades;
	}
}
