package com.backEnd.AtacadoEletronico.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@Column(name="cep", length = 100, nullable = true)
	private String cep;
	
	@Column(name="street", length = 100, nullable = true)
	private String street;
	
	@Column(name="number", length = 100, nullable = true)
	private int number;
	
	@Column(name="city", length = 100, nullable = true)
	private String city;
	
	@Column(name="state", length = 100, nullable = true)
	private String state;
	
	@Column(name="complement", length = 100, nullable = true)
	private String complement;
	
	@Column(name="country", length = 100, nullable = true)
	private String country;

	public Address() {}
	
	public Address(String cep, String street, int number, String city, String state, String complement, String country) {
		//super();
		this.cep = cep;
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
		this.complement = complement;
		this.country = country;
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


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getComplement() {
		return complement;
	}


	public void setComplement(String complement) {
		this.complement = complement;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
}
