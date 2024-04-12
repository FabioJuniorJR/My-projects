package com.courseJava.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courseJava.Project.entities.Product;



public interface ProductRepository extends JpaRepository<Product, Long> {

}
