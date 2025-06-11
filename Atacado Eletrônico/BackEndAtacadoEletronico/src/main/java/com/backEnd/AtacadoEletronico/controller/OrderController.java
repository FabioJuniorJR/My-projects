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

import com.backEnd.AtacadoEletronico.entities.Order;
import com.backEnd.AtacadoEletronico.entities.User;
import com.backEnd.AtacadoEletronico.repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping
    public List<Order> listOrder() {
    	List<Order> listOrder = orderRepository.findAll();
    	return listOrder;
    }
    
    @GetMapping(value = "/{id}")// indica que aqui tera um numero para a pesquisa
    public Order orderNumber(@PathVariable  Long number){
    	Order orderNumber = orderRepository.findById(number).get();
    	return orderNumber;
    }
    
    @PostMapping
    public Order postOrder(@RequestBody Order orderNew) {
    	Order order = orderRepository.save(orderNew);
    	return order;
    }
    
    @PutMapping
    public Order putOrder(@RequestBody Order orderEdit) {
    	Order order = orderRepository.save(orderEdit);
    	return order;
    }
    
    @DeleteMapping("/{id}")
    public Order deleteOrder(@PathVariable Long numberOrder) {
    	Order orderDelete = orderRepository.findById(numberOrder).get();
    	orderRepository.delete(orderDelete);
    	return orderDelete;
    }
	
}