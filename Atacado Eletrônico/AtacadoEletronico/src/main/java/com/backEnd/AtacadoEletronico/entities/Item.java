package com.backEnd.AtacadoEletronico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idItem;
	private String category;
	private double price;
	private int qtdeIteStoke;
	private String descrItem;
	private String name;
	private String situation;
	@ManyToOne
	@JoinColumn(name="cnpj")
	private Manufacture manufacture;
	
	
	public Item(int idItem, String category, double price, int qtdeIteStoke, String descrItem, String name,
			String situation, Manufacture manufacture) {
		super();
		this.idItem = idItem;
		this.category = category;
		this.price = price;
		this.qtdeIteStoke = qtdeIteStoke;
		this.descrItem = descrItem;
		this.name = name;
		this.situation = situation;
		this.manufacture = manufacture;
	}
	
	
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQtdeIteStoke() {
		return qtdeIteStoke;
	}
	public void setQtdeIteStoke(int qtdeIteStoke) {
		this.qtdeIteStoke = qtdeIteStoke;
	}
	public String getDescrItem() {
		return descrItem;
	}
	public void setDescrItem(String descrItem) {
		this.descrItem = descrItem;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public Manufacture getManufacture() {
		return manufacture;
	}
	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}
	
	
}
