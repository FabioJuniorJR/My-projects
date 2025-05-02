package com.courseJava.Project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")// Coloca isso para especificar, palavra reservdo do banco de dados h2, é para nao dar conflito entre a palavra reservada e o nome daa variavel no sistema aqui
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	/*Temos que implementar a relaação entre a entidade Order e User, 
	 * ja colocamos na outra classe agora colocamos aqui tambem porem 
	 * com o atributo de relação com  outra clase que é o"client" -> @ManyToOne(mappedBy = "client")
	*/
	@JsonIgnore //Com esta anotação, evitasse o LUPING de busca, entre ficar buscando Cliente tem Pedidos e Pedidos tem Clientes
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();//Pra est coleção ou qwulquer outr utilizasse somente o metodo GET. Nunca é mudada com SET
	
	public User() {
		
	}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, password, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(phone, other.phone);
	}

	public List<Order> getOrders() {
		return orders;
	}
	
	
	
}
//H2: banco de dados em memoria ue pode visualizar via WEB 
//sts: ferramenta de desenvolvimento tipo eclipse com Spring Boot para fazermos aapplication web com banco de dados. exemplo: H2
