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
    private ProductRepo productRepo;

    public List<OrderResponseDTO> findAllOrders() {
        return orderRepo.findAll().stream()
                .map(OrderMapper.INSTANCE::toResponseDTO)
                .collect(Collectors.toList());
    }

    public OrderResponseDTO createOrder(OrderCreationDTO orderDTO) {
        // Crear una nueva entidad de Orders
        Orders order = new Orders();

        // Asignar el cliente a partir de su ID
        Client client = clientRepo.findById(orderDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        order.setClient(client);

        // Asignar los productos a partir de sus IDs
        List<Product> products = productRepo.findAllById(orderDTO.getProductIds());
        order.setProducts(products);

        // Asignar la fecha de creación (parsear el string a LocalDateTime)
        order.setCreationDate(LocalDateTime.parse(orderDTO.getOrderDate()));

        // Calcular el total de la orden (precio del producto * cantidad)
        double total = products.stream().mapToDouble(Product::getPrice).sum();
        order.setTotal(total);

        // Guardar la orden en la base de datos
        Orders savedOrder = orderRepo.save(order);

        // Convertir la entidad guardada a DTO y retornarla
        return OrderMapper.INSTANCE.toResponseDTO(savedOrder);
    }

    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }
}