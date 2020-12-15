package com.crudcompleto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudcompleto.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
