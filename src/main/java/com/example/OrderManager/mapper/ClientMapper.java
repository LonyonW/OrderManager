package com.example.OrderManager.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.OrderManager.dto.ClientDTO;
import com.example.OrderManager.entity.Client;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDTO toDTO(Client client);
    Client toEntity(ClientDTO clientDTO);
}
