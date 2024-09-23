package com.example.OrderManager.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreationDTO {
    private Long clientId;
    private List<Long> productIds;

    public long getClientId() {
        return clientId;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

}