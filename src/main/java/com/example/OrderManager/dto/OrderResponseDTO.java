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
    private Long id;
    private ClientDTO client;
    private List<ProductDTO> products;
    private LocalDateTime createDate;
    private Double total;

} 