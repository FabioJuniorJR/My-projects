package com.backEnd.AtacadoEletronico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="manufacture")
public class Manufacture {
	@Id
	private String cnpj;
	private String name;
	@ManyToOne
	@JoinColumn(name="cep")
	private Address address;
	
	
	public Manufacture(String cnpj, String name, Address address) {
		//super();
		this.cnpj = cnpj;
		this.name = name;
		this.address = address;
	}
	
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAdsress(Address address) {
		this.address = address;
	}
	
	
}
