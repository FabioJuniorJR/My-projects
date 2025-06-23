package com.backEnd.AtacadoEletronico.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrderItemPK implements Serializable{

	/*
	 * Não Colocamos a classe Order e Product, poi s precisamos que a chave seja esses dois tipos juntos
	 * e nãp uma classe Order e Product que deixariam elas sendo coisas diferentes. 
	 * 
	 * Resumindo: Esse Objeto que será Chave Primária será algo unico que depois se juntará com Order e Product
	 * */
	
	@Column(name="number_order")
	private Long orderId; //Aqui nao precisamos de um Order, apenas o tipo e o valor
	
	@Column(name="id_product")
	private Long productId;// Aqui não precisamos de um Product,apenas o tipo e valor
	
	public OrderItemPK() {}
	
	public OrderItemPK(Long orderId, Long productId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
	}

	public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
 // É **essencial** sobrescrever equals() e hashCode() para chaves compostas
    // para que o JPA possa comparar corretamente as instâncias.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(orderId, that.orderId) &&
               Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }
}
