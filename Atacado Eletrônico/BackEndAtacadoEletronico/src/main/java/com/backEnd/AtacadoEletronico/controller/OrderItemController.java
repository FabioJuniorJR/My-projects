package com.backEnd.AtacadoEletronico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.backEnd.AtacadoEletronico.entities.OrderItem;
import com.backEnd.AtacadoEletronico.repository.OrderItemRepository;

public class OrderItemController {
	
	private OrderItemRepository orderItemRepository;
/*
	@PostMapping
	public OrderItem postOrderItem(@RequestBody OrderItem newItemsForOrder){
		OrderItem orderItem = orderItemRepository.save(newItemsForOrder);
		return orderItem;
	}
	
	@GetMapping
	public List<OrderItem> getListOrderItem(){
		List<OrderItem> listOrderItem = orderItemRepository.findAll();
		return listOrderItem;
		
	}
*/	
}
	
	
	
	
	
	
	
	
	
	
	/*
	@GetMapping
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        return ResponseEntity.ok(orderItems);
    }

    // Endpoint para buscar um item de pedido pela chave composta
    // Nota: Buscar por chave composta no @PathVariable pode ser mais complexo.
    // Uma abordagem mais fácil é usar parâmetros de requisição.
    @GetMapping("/by-order-and-product")
    public ResponseEntity<OrderItem> getOrderItemByOrderAndProduct(
            @RequestParam("orderId") Long orderId,
            @RequestParam("productId") Long productId) {

        OrderItemPK id = new OrderItemPK(orderId, productId);
        Optional<OrderItem> orderItem = orderItemRepository.findById(id);
        return orderItem.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    

    // Endpoint para deletar um item de pedido
    @DeleteMapping
    public ResponseEntity<Void> deleteOrderItem(
            @RequestParam("orderId") Long orderId,
            @RequestParam("productId") Long productId) {

        OrderItemPK id = new OrderItemPK(orderId, productId);
        if (orderItemRepository.existsById(id)) {
            orderItemRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }
    */

