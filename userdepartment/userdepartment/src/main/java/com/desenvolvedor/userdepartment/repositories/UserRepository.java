package com.desenvolvedor.userdepartment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.desenvolvedor.userdepartment.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	//Operações basicas de pesquisa usando a Interface Repository do JPA
	//Exemplo:
	//findAll()	Busca todos os registros
	//findById(Long id)	Busca por ID
	//save(obj)	Salva ou atualiza um objeto
	//deleteById(Long id)	Deleta pelo ID
	//findByNome(String nome)	Busca pelo campo nome (automático!)
	
	
}
