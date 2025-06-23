package com.backEnd.AtacadoEletronico.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backEnd.AtacadoEletronico.entities.Order;
import com.backEnd.AtacadoEletronico.entities.OrderItem;
import com.backEnd.AtacadoEletronico.entities.Product;
import com.backEnd.AtacadoEletronico.entities.User;
import com.backEnd.AtacadoEletronico.repository.OrderItemRepository;
import com.backEnd.AtacadoEletronico.repository.OrderRepository;
import com.backEnd.AtacadoEletronico.repository.ProductRepository;
import com.backEnd.AtacadoEletronico.repository.UserRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/orders")
public class OrderController{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired //Para associar um usuário ao pedido
	private UserRepository userRepository;
	
	
	@Transactional //Garante que tudo seja SALO JUNTO ou NADA SALVO 
	@PostMapping
	public ResponseEntity<Order> createOrderWithItemsFromEntity(@RequestBody Order newOrder) {
		
		// 1. **Verificar e Vincular o Usuário Existente:**
        if (newOrder.getUser() == null || newOrder.getUser().getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // ID do usuário é obrigatório
        }
        Optional<User> existingUserOptional = userRepository.findById(newOrder.getUser().getId());
        if (existingUserOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Usuário não encontrado no DB
        }
        
        // **Associa o objeto User completo ao Order
        newOrder.setUser(existingUserOptional.get()); 

        // **IMPORTANTE:** Se order.listOrderProduct for null do JSON, inicialize-o
        if (newOrder.getListOrderProduct() == null) {
        	newOrder.setListOrderProduct(new ArrayList<>());
        }

        List<OrderItem> itemsToProcess = new ArrayList<>(newOrder.getListOrderProduct()); // Crie uma cópia
        newOrder.getListOrderProduct().clear(); // Limpe a lista original do Order para adicionar os objetos completos e vinculados

        double totalOrderValue = 0.0;

        // 2. **Processar e Vincular os OrderItems (se houver):**
        if (!itemsToProcess.isEmpty()) { // Itera sobre a cópia dos itens recebidos no JSON
            for (OrderItem item : itemsToProcess) {
                // Verificar e Vincular o Produto Existente:
                if (item.getProduct() == null || item.getProduct().getId() == null) {
                    throw new RuntimeException("Product ID is required for order item."); // Produto sem ID
                }
                Optional<Product> existingProductOptional = productRepository.findById(item.getProduct().getId());
                if (existingProductOptional.isEmpty()) {
                    throw new RuntimeException("Product with ID " + item.getProduct().getId() + " not found."); // Produto não encontrado no DB
                }
                item.setProduct(existingProductOptional.get()); // Associa o objeto Product completo ao OrderItem

                // Vincular o Order ao OrderItem (lado ManyToOne)
                // Isso é CRÍTICO para o relacionamento bidirecional e o cascade.
                item.setOrder(newOrder); // Define o Order pai neste OrderItem

                // Preencher a chave composta OrderItemPK no OrderItem
                // Isso é feito agora nos setters de Order e Product dentro de OrderItem
                // item.setId(new OrderItemPK(order.getNumberOrder(), existingProductOptional.get().getId()));

                // Adicionar o item processado e vinculado de volta à lista do Order
                newOrder.getListOrderProduct().add(item);
                totalOrderValue += (item.getPriceOrder() * item.getQuantityProduct());
            }
            newOrder.setValueOrder(totalOrderValue); // Atualiza o valor total do pedido
        } else {
        	newOrder.setValueOrder(0.0); // Se não houver itens, o valor é 0
        }

        // 3. **Salvar o Order (e seus OrderItems em cascata):**
        // Como CascadeType.ALL está em Order para listOrderProduct,
        // o save do Order deve persistir/atualizar os OrderItems filhos.
        Order savedOrder = orderRepository.save(newOrder);

        // O saveAll em orderItemRepository.saveAll(order.getListOrderProduct());
        // pode ser redundante aqui se o cascade estiver funcionando perfeitamente,
        // mas pode ser útil para depuração ou se a cascata não se comportar como esperado.
        // Se você continuar com problemas, tente descomentar a linha abaixo:
        // if (order.getListOrderProduct() != null && !order.getListOrderProduct().isEmpty()) {
        //     orderItemRepository.saveAll(order.getListOrderProduct());
        // }

        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@GetMapping
    public List<Order> listOrder() {
    	List<Order> listOrder = orderRepository.findAll();
    	return listOrder;
    }
    
    @GetMapping(value = "/{id}")// indica que aqui tera um numero para a pesquisa
    public Order orderNumber(@PathVariable  Long number){
    	Order orderNumber = orderRepository.findById(number).get();
    	return orderNumber;
    }
    
    @PostMapping
    public Order postOrder(@RequestBody Order orderNew) {
    	Order order = orderRepository.save(orderNew);
    	return order;
    }
    
    @PutMapping
    public Order putOrder(@RequestBody Order orderEdit) {
    	Order order = orderRepository.save(orderEdit);
    	return order;
    }
    
    @DeleteMapping("/{id}")
    public Order deleteOrder(@PathVariable Long numberOrder) {
    	Order orderDelete = orderRepository.findById(numberOrder).get();
    	orderRepository.delete(orderDelete);
    	return orderDelete;
    }
	*/
