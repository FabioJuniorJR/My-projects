
package com.backEnd.AtacadoEletronico.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="ItemsOrder")
public class ItemsOrder {
	@EmbeddedId
	private ItemsOrderCompost id;
	
	@ManyToOne
	@MapsId("idItem") //nome do campo dentro de Item
	@JoinColumn(name="idItem")
	private Item item;
	@ManyToOne
	@MapsId("numOrder") //nome do campo dentro de Order
	@JoinColumn(name="numOrder")
	private Order order;
	
	private int qtdeOrder;
	private double priceOrder;
	
	
	public ItemsOrder(ItemsOrderCompost id, Item item, Order order, int qtdeOrder, double priceOrder) {
		super();
		this.id = id;
		this.item = item;
		this.order = order;
		this.qtdeOrder = qtdeOrder;
		this.priceOrder = priceOrder;
	}
	
	
	public ItemsOrderCompost getId() {
		return id;
	}
	public void setId(ItemsOrderCompost id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getQtdeOrder() {
		return qtdeOrder;
	}
	public void setQtdeOrder(int qtdeOrder) {
		this.qtdeOrder = qtdeOrder;
	}
	public double getPriceOrder() {
		return priceOrder;
	}
	public void setPriceOrder(double priceOrder) {
		this.priceOrder = priceOrder;
	}
	
	
}
