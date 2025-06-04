package com.backEnd.AtacadoEletronico.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="userName", length = 100, nullable = true)
    private String name;
    
    @Column(name="email", length = 100, nullable = true)
    private String email;
    
    @Column(name="senha", length = 100, nullable = true)
    private String password;
    
    @Column(name="phone", length = 100, nullable = true)
    private String phone;
    
    @JoinColumn(name="cep")
    @ManyToOne(cascade = CascadeType.ALL)//Permite fazer a inserção e salvar o endereço junto ao usuário
    private Address address;
    
    public User() {} 
    
	public User(int id, String name, String email, String password, String phone, Address address) {
		//super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}

    
    
}