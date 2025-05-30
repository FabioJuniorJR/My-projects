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
@Table(name="nf_header")
public class nfHeader {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private int numNf;
	private Date dtBuyer;
	@ManyToOne
	@JoinColumn(name="cnpj")
	private Company company;
	@ManyToOne
	@JoinColumn(name="cpfCnpj")
	private User user;
	
	
	public nfHeader(int numNf, Date dtBuyer, Company company, User user) {
		//super();
		this.numNf = numNf;
		this.dtBuyer = dtBuyer;
		this.company = company;
		this.user = user;
	}
	
	
	public int getNumNf() {
		return numNf;
	}
	public void setNumNf(int numNf) {
		this.numNf = numNf;
	}
	public Date getDtBuyer() {
		return dtBuyer;
	}
	public void setDtBuyer(Date dtBuyer) {
		this.dtBuyer = dtBuyer;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
