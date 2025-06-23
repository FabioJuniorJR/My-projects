package com.backEnd.AtacadoEletronico.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="order_item")
public class OrderItem {
	
	@EmbeddedId // Indica que a chave primária é um objeto embutido
	private OrderItemPK id = new OrderItemPK(); // Instancia a chave composta
	
	
	@ManyToOne
	@MapsId("orderId")// Mapeia o campo 'orderId' da chave composta 'id'
	@JoinColumn(name="number_order")// Coluna que faz a junção no banco de dados
	private Order order;
	
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name="id_product")
	private Product product;
	
	@Column(name = "qunatity_product", length = 100, nullable = false)
	private int quantityProduct;
	
	@Column(name="price_order", length = 100, nullable = false)
	private double priceOrder;
	
	public OrderItem() {}

	public OrderItem( Order order, Product product, int quantityProduct, double priceOrder) {
		//super();
		//this.id = id;
		this.order = order;
		this.product = product;
		this.quantityProduct = quantityProduct;
		this.priceOrder = priceOrder;
		this.id.setOrderId(order.getNumberOrder());
		this.id.setProductId(product.getId());
	}

	public OrderItemPK getId() {
		return id;
	}

	public void setId(OrderItemPK id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
		if(this.id == null) {
			this.id = new OrderItemPK();
		}
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
		if(this.id == null) {
			this.id = new OrderItemPK();
		}
	}

	public int getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	public double getPriceOrder() {
		return priceOrder;
	}

	public void setPriceOrder(double priceOrder) {
		this.priceOrder = priceOrder;
	}
	
	
}