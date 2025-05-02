package com.courseJava.Project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseJava.Project.entities.Category;
import com.courseJava.Project.services.CategoryService;

/*
 * Camada de recursos Web controlada por recurso Rest
 * */

@RestController
@RequestMapping(value = "/categories") //Caminho relacionado a reposta de busca a entidade Categorys
public class CategoryResourse {
	
	@Autowired
	private CategoryService service;
	
	//metodo retorno para acessar os usuarios
	@GetMapping //Responde a requisição tipo GET do http
	public ResponseEntity<List<Category>> findALL(){ // ResponseEntity - tipo de retorno os usuarios
		List<Category> listCategory = service.findAll();
		return ResponseEntity.ok().body(listCategory);//Retorno a resposta do http se deu certo a operação  ou não
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){//Coloque @PathVariable para o SPRING aceitar esse ID e considera-lo com o parametro que chegara popr 
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
