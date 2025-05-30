package com.backEnd.AtacadoEletronico.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String cnpj;
	private String name;
	@ManyToOne
	@JoinColumn(name="cep")
	private Address address;
	private Date dtBrith;
	
	public Company(String cnpj, String name, Address address, Date dtBrith) {
		super();
		this.cnpj = cnpj;
		this.name = name;
		this.address = address;
		this.dtBrith = dtBrith;
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
	public void setAddress(Address address) {
		this.address = address;
	}
	public Date getDtBrith() {
		return dtBrith;
	}
	public void setDtBrith(Date dtBrith) {
		this.dtBrith = dtBrith;
	}
	
	
	
	
}
