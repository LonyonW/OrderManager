package com.example.OrderManager.dto;

import java.util.List;

public class OrderCreationDTO {
    private Long clientId;
    private List<Long> productIds;
    private String orderDate;  // Fecha de la orden

    // Constructor sin argumentos
    public OrderCreationDTO() {
    }

    // Constructor con argumentos
    public OrderCreationDTO(Long clientId, List<Long> productIds, String orderDate) {
        this.clientId = clientId;
        this.productIds = productIds;
        this.orderDate = orderDate;
    }

    // Getters y Setters
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    // toString
    @Override
    public String toString() {
        return "OrderCreationDTO{" +
                "clientId=" + clientId +
                ", productIds=" + productIds +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }

    // Implementación del método setClient
    public void setClient(Client client) {
        this.clientId = client.getId();
    }
}