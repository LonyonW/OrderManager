package com.example.OrderManager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")  // Cambia el nombre de la tabla a "orders"
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToMany
    private List<Product> products;

    private LocalDateTime createDate = LocalDateTime.now();

    public Double calculateTotal() {
        return products.stream()
                       .mapToDouble(Product::getPrice)
                       .sum();
    }
}