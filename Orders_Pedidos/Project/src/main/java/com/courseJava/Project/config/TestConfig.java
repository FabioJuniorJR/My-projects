//Classe para TESTES e popular BD no inicio do desenvolvimento
/*Vai rodar apenas para testes e o programa só vai saber ue é para testar por causa 
	do @Profile("test")
*/

package com.courseJava.Project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.courseJava.Project.entities.User;
import com.courseJava.Project.repositories.UserRepository;

@Configuration
@Profile("test")//O spring Só vai rodar esta  aplicação quando estiver no perfil de teste
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception { //TUDO aqui dentro será executado quando o programa rodar
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");// O ID é nulo porque o BD coloca o ID 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

		userRepository.saveAll(Arrays.asList(u1, u2)); //Comando para salvar uma lista de objetos no banco de dados
	}
}
