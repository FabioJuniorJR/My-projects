package com.courseJava.Project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseJava.Project.entities.Product;
import com.courseJava.Project.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired // Assim o SPRING a injeção de dependencia claramente para o programador
	private ProductRepository repository;
	
	public List<Product>findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) { //Retorno um objeto OPTIONAL DESDE O JAV 8
		Optional<Product> obj = repository.findById(id);
		return obj.get();// Operação GET do OPTIONAL retorna o objeto Product que etiver dentro do obj
	}
}
