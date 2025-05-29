package com.backEnd.AtacadoEletronico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="manufacture")
public class Manufacture {
	@Id
	private String cnpj;
	private String name;
	@ManyToOne
	private Address adsress;
	
	
	public Manufacture(String cnpj, String name, Address adsress) {
		//super();
		this.cnpj = cnpj;
		this.name = name;
		this.adsress = adsress;
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
	public Address getAdsress() {
		return adsress;
	}
	public void setAdsress(Address adsress) {
		this.adsress = adsress;
	}
	
	
}
