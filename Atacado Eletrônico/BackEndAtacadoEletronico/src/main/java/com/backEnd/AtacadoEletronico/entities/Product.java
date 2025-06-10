package com.backEnd.AtacadoEletronico.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name = "category", length = 100, nullable = true)
	private String category;
	
	@Column(name = "name", length = 100, nullable = true)
	private String name;
	
	@Column(name = "price", length = 100, nullable = true)
	private double price;
	
	@Column(name = "quantityStoke", length = 100, nullable = true)
	private int qtdeStoke;
	
	@Column(name = "description", length = 100, nullable = true)
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)//Permite salvar junto na inserção os dois juntos
	@JoinColumn(name="nameManufacture")
	private Manufacture manufacture;

	public Product() {}
	
	public Product(Long id, String category, Manufacture manufacture, String name, double price, int qtdeStoke,
			String description) {
		//super();
		this.id = id;
		this.category = category;
		this.manufacture = manufacture;
		this.name = name;
		this.price = price;
		this.qtdeStoke = qtdeStoke;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Manufacture getManufacture() {
		return manufacture;
	}

	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQtdeStoke() {
		return qtdeStoke;
	}

	public void setQtdeStoke(int qtdeStoke) {
		this.qtdeStoke = qtdeStoke;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}