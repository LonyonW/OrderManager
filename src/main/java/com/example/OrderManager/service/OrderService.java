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

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    
    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private ProductRepo productRepo;  

    @Autowired
    private OrderMapper orderMapper;

    public OrderResponseDTO createOrder(OrderCreationDTO dto) {
        Client client = clientRepo.findById(dto.getClientId())
            .orElseThrow(() -> new RuntimeException("Client not found"));

        List<Product> products = productRepo.findAllById(dto.getProductIds());
        Orders order = new Orders();
        order = orderMapper.toEntity(dto, client, products);

        Orders savedOrder = orderRepo.save(order);
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