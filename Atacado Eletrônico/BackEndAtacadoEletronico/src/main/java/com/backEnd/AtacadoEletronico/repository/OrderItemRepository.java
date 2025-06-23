package com.backEnd.AtacadoEletronico.repository;

import com.backEnd.AtacadoEletronico.entities.OrderItem;
import com.backEnd.AtacadoEletronico.entities.OrderItemPK; // Importa a classe da chave composta
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
    // JpaRepository<[Sua Entidade], [Tipo da Chave Primária Composta]>
}