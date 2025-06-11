package com.backEnd.AtacadoEletronico.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="manufacture")
public class Manufacture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_manufacture", nullable = false)
	private Long id;
	
	@Column(name = "cnpj", length = 100, nullable = false)
	private String cnpj;
	
	@Column(name="name", length = 100, nullable = false)
	private String name;
	
	public Manufacture() {}

	public Manufacture(Long id, String cnpj, String name) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
}
