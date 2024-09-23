package com.example.OrderManager.service;

import com.example.OrderManager.dto.ClientDTO;
import com.example.OrderManager.entity.Client;
import com.example.OrderManager.mapper.ClientMapper;
import com.example.OrderManager.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;

    public List<ClientDTO> findAllClients() {
        return clientRepo.findAll().stream()
                .map(ClientMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    // Nuevo método para crear un cliente
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = ClientMapper.INSTANCE.toEntity(clientDTO);  // Mapear de DTO a entidad
        Client savedClient = clientRepo.save(client);  // Guardar el cliente
        return ClientMapper.INSTANCE.toDTO(savedClient);  // Devolver el cliente guardado como DTO
    }
}
