package com.example.OrderManager.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreationDTO {
    private Long customerId;
    private List<Long> productIds;

    public long getClientId() {
        return customerId;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

}