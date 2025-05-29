package com.backEnd.AtacadoEletronico.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numOrder;
	@OneToOne
	private User user;
	private Date dtOrder;
	private double priceOrder;
	
	
	public Order(int numOrder, User user, Date dtOrder, double priceOrder) {
		//super();
		this.numOrder = numOrder;
		this.user = user;
		this.dtOrder = dtOrder;
		this.priceOrder = priceOrder;
	}
	
	
	public int getNumOrder() {
		return numOrder;
	}
	public void setNumOrder(int numOrder) {
		this.numOrder = numOrder;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDtOrder() {
		return dtOrder;
	}
	public void setDtOrder(Date dtOrder) {
		this.dtOrder = dtOrder;
	}
	public double getPriceOrder() {
		return priceOrder;
	}
	public void setPriceOrder(double priceOrder) {
		this.priceOrder = priceOrder;
	}

	
}
