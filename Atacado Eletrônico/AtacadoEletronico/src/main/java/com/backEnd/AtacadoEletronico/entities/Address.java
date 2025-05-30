package com.backEnd.AtacadoEletronico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	@Id
	private String cep;
	private String street;
	private String district;
	private String numberLocal;
	private String country;
	private String complement;
	
	
	public Address(String cep, String street, String district, String numberLocal, String country, String complement) {
		//super();
		this.cep = cep;
		this.street = street;
		this.district = district;
		this.numberLocal = numberLocal;
		this.country = country;
		this.complement = complement;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getNumberLocal() {
		return numberLocal;
	}
	public void setNumberLocal(String numberLocal) {
		this.numberLocal = numberLocal;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	
	
}
