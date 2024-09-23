package com.example.OrderManager.mapper;

import com.example.OrderManager.dto.OrderResponseDTO;
import com.example.OrderManager.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "client.id", target = "id")
    @Mapping(source = "client.name", target = "clientName")
    @Mapping(source = "products", target = "products")
    @Mapping(source = "creationDate", target = "orderDate")
    OrderResponseDTO toResponseDTO(Orders order);
}