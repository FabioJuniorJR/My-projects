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

import com.backEnd.AtacadoEletronico.entities.User;
import com.backEnd.AtacadoEletronico.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    
    @GetMapping
    public List<User> listUser() {
    	List<User> listUser = userRepository.findAll();
    	return listUser;
    }
    
    @GetMapping(value = "/{id}")// indica que aqui tera um numero para a pesquisa
    public User userId(@PathVariable  Long id){
    	User userId = userRepository.findById(id).get();
    	return userId;
    }
    
    @PostMapping
    public User postUser(@RequestBody User userNew) {
    	User user = userRepository.save(userNew);
    	return user;
    }
    
    @PutMapping
    public User putUser(@RequestBody User userEdit) {
    	User user = userRepository.save(userEdit);
    	return user;
    }
    
    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable Long id) {
    	User userDelete = userRepository.findById(id).get();
    	userRepository.delete(userDelete);
    	return userDelete;
    }
    
    
    
    
    
    
    
}