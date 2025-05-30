package com.backEnd.AtacadoEletronico.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	private String cpfCnpj;
	private String name;
	private Date dateBirth;
	private String email;
	private String password;
	private String phone;
	private String gender;
	private String typePeolpe;
	@ManyToOne
	@JoinColumn(name="cep")
	private Address address;
	
	
	public User(String cpfCnpj, String name, Date dateBirth, String email, String password, String phone, String gender,
			String typePeolpe, Address address) {
		//super();
		this.cpfCnpj = cpfCnpj;
		this.name = name;
		this.dateBirth = dateBirth;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.gender = gender;
		this.typePeolpe = typePeolpe;
		this.address = address;
	}
	
	
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpf(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTypePeolpe() {
		return typePeolpe;
	}
	public void setTypePeolpe(String typePeolpe) {
		this.typePeolpe = typePeolpe;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
