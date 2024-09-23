package com.example.OrderManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.OrderManager.dto.ClientDTO;
import com.example.OrderManager.dto.OrderCreationDTO;
import com.example.OrderManager.dto.ProductDTO;
import com.example.OrderManager.service.ClientService;
import com.example.OrderManager.service.OrderService;
import com.example.OrderManager.service.ProductService;

@RestController
@RequestMapping("")
public class MainController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;

    @GetMapping("/orders")
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.ok(orderService.findAllOrders());
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody OrderCreationDTO orderDTO) {
    return ResponseEntity.ok(orderService.createOrder(orderDTO));
}


    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/customers")
    public ResponseEntity<?> getAllClients() {
        return ResponseEntity.ok(clientService.findAllClients());
    }

    // Nuevo endpoint para crear un cliente
    @PostMapping("/customers")
    public ResponseEntity<?> createClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.createClient(clientDTO));
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(productService.findAllProducts());
    }

    // Nuevo endpoint para crear un producto
    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }
}
