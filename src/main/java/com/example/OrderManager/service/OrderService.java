package com.example.OrderManager.service;

import com.example.OrderManager.dto.OrderCreationDTO;
import com.example.OrderManager.dto.OrderResponseDTO;
import com.example.OrderManager.entity.Client;
import com.example.OrderManager.entity.Orders;
import com.example.OrderManager.entity.Product;
import com.example.OrderManager.mapper.OrderMapper;
import com.example.OrderManager.repo.ClientRepo;
import com.example.OrderManager.repo.OrderRepo;
import com.example.OrderManager.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    
    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private ProductRepo productRepo;  // Inyectado con @Autowired

    @Autowired
    private OrderMapper orderMapper;

    public OrderResponseDTO createOrder(OrderCreationDTO dto) {
        Client client = clientRepo.findById(dto.getClientId())
            .orElseThrow(() -> new RuntimeException("Client not found"));

        System.out.println("CLIENTEEEEEE: " + client.toString());

        List<Product> products = productRepo.findAllById(dto.getProductIds());
        Orders order = orderMapper.toEntity(dto, client, products);

        System.out.println("Orden antes de ser guardada: " + order.toString());

        Orders savedOrder = orderRepo.save(order);
        System.out.println("Orden guardada con éxito: " + savedOrder.toString());
        return orderMapper.toDto(savedOrder);
    }

    public List<OrderResponseDTO> getAllOrders() {
        return orderRepo.findAll().stream()
            .map(orderMapper::toDto)
            .collect(Collectors.toList());
    }

    

    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }
}