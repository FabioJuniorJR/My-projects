package com.courseJava.Project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseJava.Project.entities.Order;
import com.courseJava.Project.services.OrderService;

/*
 * Camada de recursos Web controlada por recurso Rest
 * */

@RestController
@RequestMapping(value = "/orders") //Caminho relacionado a reposta de busca a entidade Orders
public class OrderResourse {
	
	@Autowired
	private OrderService service;
	
	//metodo retorno para acessar os usuarios
	@GetMapping //Responde a requisição tipo GET do http
	public ResponseEntity<List<Order>> findALL(){ // ResponseEntity - tipo de retorno os usuarios
		List<Order> listOrder = service.findAll();
		return ResponseEntity.ok().body(listOrder);//Retorno a resposta do http se deu certo a operação  ou não
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){//Coloque @PathVariable para o SPRING aceitar esse ID e considera-lo com o parametro que chegara popr 
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
