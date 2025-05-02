package com.courseJava.Project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseJava.Project.entities.Order;
import com.courseJava.Project.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired // Assim o SPRING a injeção de dependencia claramente para o programador
	private OrderRepository repository;
	
	public List<Order>findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) { //Retorno um objeto OPTIONAL DESDE O JAV 8
		Optional<Order> obj = repository.findById(id);
		return obj.get();// Operação GET do OPTIONAL retorna o objeto Order que etiver dentro do obj
	}
}
