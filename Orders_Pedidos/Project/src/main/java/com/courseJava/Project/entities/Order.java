package com.courseJava.Project.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.courseJava.Project.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
//Temos que fazer notações pra mostrar que esta classe vai ser uma tabela do banco de dados -> @Entity, @Id, @GeneratedValue
	/*
	 * Temos que implementar o relacionamento entre pedido e cliente para o JPA;
	 * trasnformar em chave estrangeira para o banco de dados
	 * -> @ManyToOne, @JoinColumn
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z',", timezone = "GMT")
	private Long id;
	private Instant moment; // Após java 8 é usado INSTANT o inve de Date

	private String orderstatus;

	@ManyToOne
	@JoinColumn
	private User client;
	
	@OneToMany(mappedBy = "id.order")// É o id que tem os itens, por isso usamos ele. Para buscar os itens pelo id, tem o GET láa em baixo
	private Set<OrderItem> items = new HashSet<>();
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;

	

	public Order() {
	}

	public Order(Long id, Instant moment, OrderStatus orderstatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderstatus(orderstatus);;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderstatus() {
		return OrderStatus.valueOf(orderstatus); // Transforma o tipo OrderStatus em um Inteiro para que retorno o valor
													// da Ordem de Status
	}

	public void setOrderstatus(OrderStatus orderstatus) {
		if(orderstatus != null) {
		this.orderstatus = orderstatus.getCode(); //Pega o valor da Ordem de Status pelo metodo getCode da classe OrderStatus
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public Set<OrderItem>getItems(){// A partir daqui o pedido conhece os itens dele
		return items;
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for(OrderItem x : items) {
			sum += x.getSubTotal();
		}
		return sum;
	}
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(client, id, moment);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(client, other.client) && Objects.equals(id, other.id)
				&& Objects.equals(moment, other.moment);
	}

}
