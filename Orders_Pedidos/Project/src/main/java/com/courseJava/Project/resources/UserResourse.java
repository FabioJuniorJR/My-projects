package com.courseJava.Project.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.courseJava.Project.entities.User;
import com.courseJava.Project.services.UserService;

/*
 * Camada de recursos Web controlada por recurso Rest
 * */

@RestController
@RequestMapping(value = "/users") //Caminho relacionado a reposta de busca a entidade users
public class UserResourse {
	
	@Autowired
	private UserService service;
	
	//metodo retorno para acessar os usuarios
	@GetMapping //Responde a requisição tipo GET do http
	public ResponseEntity<List<User>> findALL(){ // ResponseEntity - tipo de retorno os usuarios
		List<User> listUser = service.findAll();
		return ResponseEntity.ok().body(listUser);//Retorno a resposta do http se deu certo a operação  ou não
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){//Coloque @PathVariable para o SPRING aceitar esse ID e considera-lo com o parametro que chegara popr 
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping //Vai fazer um pré processamento para avisar que vai fazer que esse metodo vai receber um metodo post do http
	public ResponseEntity<User> insert(@RequestBody User obj){ //Para dizer que ete objeto vai chegaar no modo Json e esse Json vai ser deserealizado para um objeto User, tenho que colocar uma anotacion @RequestBody
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}") //Para deletar usa end point no padrao rest é o delet
	public ResponseEntity<Void> delete(@PathVariable Long id){ 
		//Variavel da URL @PathVariable
		//Void Retorna uma resposta sem corpo
		service.delete(id);
		return ResponseEntity.noContent().build();	
	} 
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	
}
