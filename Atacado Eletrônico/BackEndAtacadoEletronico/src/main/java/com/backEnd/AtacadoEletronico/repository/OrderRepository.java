package com.backEnd.AtacadoEletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backEnd.AtacadoEletronico.entities.Order;

//Classe responsavel por TODAS as OPERAÇÕES BÁSICAS DE PESQUISA, SALVAR, ATAUALIZAR, DELETAR -> CRUD resumidamente
//Essa extensão do JPA ja tem internamente feito, o codigo de pesquisa, só precisamos de uma injeção de dependencia do contralador e acessarmos, essa classe de lá do controlador.

public interface OrderRepository extends JpaRepository<Order, Long>{
	 // JpaRepository<[Sua Entidade], [Tipo da Chave Primária]>
    // Ele já fornece métodos como save(), findById(), findAll(), deleteById(), etc.
}
