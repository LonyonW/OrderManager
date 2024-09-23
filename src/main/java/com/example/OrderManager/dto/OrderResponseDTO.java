package com.example.OrderManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {
    private Long id;  // ID de la orden
    private ClientDTO client;  // Información del cliente que realizó la orden
    private List<ProductDTO> products;  // Lista de productos en la orden
    private LocalDateTime creationDate;  // Fecha de creación de la orden
    private Double total;  // Total del precio de la orden
}
