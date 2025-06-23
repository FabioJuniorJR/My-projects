package com.backEnd.AtacadoEletronico.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="number_order", length = 100, nullable = false)
	private Long numberOrder;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_user")
	private User user;
	
	@Column(name = "date_order", length = 100, nullable = false)
	private Date dateOrder;
	
	@Column(name="date_delivery", length = 100, nullable = false)
	private Date dateDelivery;
	
	@Column(name = "value_order", length = 100, nullable = false)
	private double valueOrder;
	
	//@JoinColumn(name="")
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> listOrderProduct;
	
	
	public Order() {}


	public Order(Long numberOrder, User user, Date dateOrder, Date dateDelivery, double valueOrder) {
		super();
		this.numberOrder = numberOrder;
		this.user = user;
		this.dateOrder = dateOrder;
		this.dateDelivery = dateDelivery;
		this.valueOrder = valueOrder;
	}

	public Long getNumberOrder() {
		return numberOrder;
	}

	public void setNumberOrder(Long numberOrder) {
		this.numberOrder = numberOrder;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Date getDateDelivery() {
		return dateDelivery;
	}

	public void setDateDelivery(Date dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	public double getValueOrder() {
		return valueOrder;
	}

	public void setValueOrder(double valueOrder) {
		this.valueOrder = valueOrder;
	}


	public List<OrderItem> getListOrderProduct() {
		return listOrderProduct;
	}


	public void setListOrderProduct(List<OrderItem> listOrderProduct) {
		this.listOrderProduct = listOrderProduct;
	}
	
	
	
}