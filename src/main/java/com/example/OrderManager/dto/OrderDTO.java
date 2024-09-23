package com.example.OrderManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private ClientDTO client;
    private List<ProductDTO> products;
    private LocalDate creationDate;
    private Double total;
}

