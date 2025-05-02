//Classe para TESTES e popular BD no inicio do desenvolvimento
/*Vai rodar apenas para testes e o programa só vai saber ue é para testar por causa 
	do @Profile("test")
*/

package com.courseJava.Project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.courseJava.Project.entities.Category;
import com.courseJava.Project.entities.Order;
import com.courseJava.Project.entities.OrderItem;
import com.courseJava.Project.entities.Payment;
import com.courseJava.Project.entities.Product;
import com.courseJava.Project.entities.User;
import com.courseJava.Project.entities.enums.OrderStatus;
import com.courseJava.Project.repositories.CategoryRepository;
import com.courseJava.Project.repositories.OrderItemRepository;
import com.courseJava.Project.repositories.OrderRepository;
import com.courseJava.Project.repositories.ProductRepository;
import com.courseJava.Project.repositories.UserRepository;

@Configuration
@Profile("test")//O spring Só vai rodar esta  aplicação quando estiver no perfil de teste
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception { //TUDO aqui dentro será executado quando o programa rodar
		Category category1 = new Category(null, "Eletronic");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(category2);
		p2.getCategories().add(category1);
		p2.getCategories().add(category3);
		p3.getCategories().add(category3);
		p4.getCategories().add(category3);
		p5.getCategories().add(category2);
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));//Salva novamente só que dessa vez com a categoria

		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");// O ID é nulo porque o BD coloca o ID 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,(u1));
		Order o2 = new Order(null, Instant.parse("2017-06-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,(u2));
		Order o3 = new Order(null, Instant.parse("2017-06-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,(u1));

		
		
		userRepository.saveAll(Arrays.asList(u1, u2)); //COMANDO PARA SALVAR NO "BANCO DE DADOS"
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);// Para salvar um objeto dependente numa relação um para um, não se chama o repository
		o1.setPayment(pay1);
		orderRepository.save(o1);
		
		
	}
}
