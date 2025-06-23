package com.backEnd.AtacadoEletronico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:5173")// Aqui coloca a PORT do Front End
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
	
	@PutMapping("/{id}")
	public Product putProduct(@PathVariable Long id, @RequestBody Product productUpdate) {
		
		Product productFinded = productRepository.findById(id).get();
		if(productFinded == null) {
			System.out.println("Product not Found");
		}else{
			System.out.println("Product Found");
			
			productFinded.setCategory(productUpdate.getCategory());
			productFinded.setDescription(productUpdate.getDescription());
			productFinded.setId(productUpdate.getId());
			productFinded.setImgURL(productUpdate.getImgURL());
			productFinded.setManufacture(productUpdate.getManufacture());
			productFinded.setName(productUpdate.getName());
			productFinded.setPrice(productUpdate.getPrice());
			productFinded.setQtdeStoke(productUpdate.getQtdeStoke());
			
			Product productAfterUpdate = productRepository.save(productUpdate);
			return productAfterUpdate;
		}
		
		System.out.println("Product Not Save");
		return null;
	}
	
	@DeleteMapping("/{id}")
	public Product deleteProduct(@PathVariable Long id) {
		Product product = productRepository.findById(id).get();
		productRepository.delete(product);
		return product;
	}
	
	
}