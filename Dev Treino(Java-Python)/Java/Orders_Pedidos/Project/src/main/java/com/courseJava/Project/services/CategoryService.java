package com.courseJava.Project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseJava.Project.entities.Category;
import com.courseJava.Project.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired // Assim o SPRING a injeção de dependencia claramente para o programador
	private CategoryRepository repository;
	
	public List<Category>findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) { //Retorno um objeto OPTIONAL DESDE O JAV 8
		Optional<Category> obj = repository.findById(id);
		return obj.get();// Operação GET do OPTIONAL retorna o objeto Category que etiver dentro do obj
	}
}
