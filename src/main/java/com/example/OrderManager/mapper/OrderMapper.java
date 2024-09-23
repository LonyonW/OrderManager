package com.example.OrderManager.mapper;

import com.example.OrderManager.dto.OrderCreationDTO;
import com.example.OrderManager.dto.OrderResponseDTO;
import com.example.OrderManager.entity.Client;
import com.example.OrderManager.entity.Orders;
import com.example.OrderManager.entity.Product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;


// OrderMapper.java
@Mapper(componentModel = "spring", uses = {ClientMapper.class, ProductMapper.class})
public interface OrderMapper {
    @Mapping(target = "createDate", expression = "java(java.time.LocalDateTime.now())")
    Orders toEntity(OrderCreationDTO dto, Client client, List<Product> products);

    @Mapping(target = "total", expression = "java(order.calculateTotal())")
    OrderResponseDTO toDto(Orders order);
}


