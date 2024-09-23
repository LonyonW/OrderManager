package com.example.OrderManager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.OrderManager.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}

