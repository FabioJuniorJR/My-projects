/*package com.backEnd.AtacadoEletronico.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backEnd.AtacadoEletronico.entities.Order;
import com.backEnd.AtacadoEletronico.entities.OrderItem;
import com.backEnd.AtacadoEletronico.entities.Product;
import com.backEnd.AtacadoEletronico.entities.User;
import com.backEnd.AtacadoEletronico.repository.OrderRepository;
import com.backEnd.AtacadoEletronico.repository.ProductRepository;
import com.backEnd.AtacadoEletronico.repository.UserRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public Order criarPedido(String cpf, List<Long> produtosIds, List<Integer> quantidades) {
        User user = userRepository.findById(cpf).orElseThrow();

        Order pedido = new Order(null, null, user, null);
        pedido.setUser(user);
        pedido.setDate(LocalDate.now());

        List<OrderItem> itens = new ArrayList<>();

        for (int i = 0; i < produtosIds.size(); i++) {
            Product produto = productRepository.findById(produtosIds.get(i)).orElseThrow();
            int quantidade = quantidades.get(i);

            if (produto.getStock() < quantidade) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getName());
            }

            produto.setStock(produto.getStock() - quantidade);
            productRepository.save(produto);

            OrderItem item = new OrderItem(null, pedido, produto, quantidade, null);
            item.setProduct(produto);
            item.setQuantity(quantidade);
            item.setUnitPrice(produto.getPrice());
            item.setOrder(pedido);

            itens.add(item);
        }

        pedido.setItems(itens);
        return orderRepository.save(pedido);
    }
}*/



