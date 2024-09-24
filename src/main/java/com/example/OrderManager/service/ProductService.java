package com.example.OrderManager.service;

import com.example.OrderManager.dto.ProductDTO;
import com.example.OrderManager.entity.Product;
import com.example.OrderManager.mapper.ProductMapper;
import com.example.OrderManager.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<ProductDTO> findAllProducts() {
        return productRepo.findAll().stream()
                .map(ProductMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);  
        Product savedProduct = productRepo.save(product);  
        return ProductMapper.INSTANCE.toDTO(savedProduct); 
    }
}
