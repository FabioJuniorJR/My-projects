//Classe responavel por manipular o User
//Classe Reponsavel por SALVAR Informações no BD

package com.courseJava.Project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.courseJava.Project.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
