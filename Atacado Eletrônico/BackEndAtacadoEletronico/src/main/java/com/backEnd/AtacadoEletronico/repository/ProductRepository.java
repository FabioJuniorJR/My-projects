package com.backEnd.AtacadoEletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backEnd.AtacadoEletronico.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{}