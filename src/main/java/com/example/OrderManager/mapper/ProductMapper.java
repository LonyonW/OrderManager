package com.example.OrderManager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.OrderManager.dto.ProductDTO;
import com.example.OrderManager.entity.Product;



@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);
}

