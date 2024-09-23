package com.example.OrderManager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.OrderManager.entity.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
}

