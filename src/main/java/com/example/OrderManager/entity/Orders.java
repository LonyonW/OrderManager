package com.example.OrderManager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")  
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id") //added
    private Client client;

    @ManyToMany
    @JoinTable(
        name = "orders_products",
        joinColumns = @JoinColumn(name = "orders_id"),
        inverseJoinColumns = @JoinColumn(name = "products_id")
    )
    private List<Product> products;

    private LocalDateTime createDate = LocalDateTime.now();

    public void setId(Long id) {
        this.id = id;
    }

    public Double calculateTotal() {
        return products.stream()
                       .mapToDouble(Product::getPrice)
                       .sum();
    }
}