package com.desenvolvedor.userdepartment.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvedor.userdepartment.entities.User;
import com.desenvolvedor.userdepartment.repositories.UserRepository;


@RestController
@RequestMapping(value = "/users")// Aqui eu digo que ele vai acessar apenas os users
public class UserController {
	// Precissmos do CONTROLLER para receber as requisições e responder as requisições

	@Autowired//Para instanciar usando ferramenta sem colocar new...
	private UserRepository repositoryUser;
		
	@GetMapping //Colocamos o GET para informar na requisição o verbo(tipo de requisiçao(nao caso é uma busca(GET)))
	public List<User> findAll(){
		// Aqui queros buscar uma Lista(List) de usuarios(User)
		//Buscara todos os usuarios
		//Para acessar é o nosso objeto UserRepository
		List<User> resultFindAllUser = repositoryUser.findAll();//findAll vem do Spring e ja manda a consulta de todos sem precisa de logica complexa,mas agora precisamos receber em alguma variavel
		return resultFindAllUser;
		
	}



}
