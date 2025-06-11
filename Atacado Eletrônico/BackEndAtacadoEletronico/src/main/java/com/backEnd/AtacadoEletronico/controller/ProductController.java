package com.backEnd.AtacadoEletronico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backEnd.AtacadoEletronico.entities.Product;
import com.backEnd.AtacadoEletronico.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController{
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> listProduct(){
		List<Product> listProduct = productRepository.findAll();
		System.out.println("Retornando");
		return listProduct;
	}
	
	@PostMapping
	public Product postProduct(@RequestBody Product productEdit) {
		productRepository.save(productEdit);
		return productEdit;
	}
	
	@PutMapping
	public Product putProduct(@RequestBody Product product) {
		productRepository.save(product);
		return product;
	}
	
	@DeleteMapping("/{id}")
	public Product deleteProduct(@PathVariable Long id) {
		Product product = productRepository.findById(id).get();
		productRepository.delete(product);
		return product;
	}
	
	
}