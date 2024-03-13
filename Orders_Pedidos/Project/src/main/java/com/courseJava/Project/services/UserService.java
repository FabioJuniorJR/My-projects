package com.courseJava.Project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseJava.Project.entities.User;
import com.courseJava.Project.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired // Assim o SPRING a injeção de dependencia claramente para o programador
	private UserRepository repository;
	
	public List<User>findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) { //Retorno um objeto OPTIONAL DESDE O JAV 8
		Optional<User> obj = repository.findById(id);
		return obj.get();// Operação GET do OPTIONAL retorna o objeto USER que etiver dentro do obj
	}
}
