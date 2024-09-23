package com.example.OrderManager.repo;

import com.example.OrderManager.entity.Orders;

import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders, Long> {  // Cambiar String por Long
    List<Orders> findByClientId(Long clientId);  // Si clientId es Long en la entidad Client
}
