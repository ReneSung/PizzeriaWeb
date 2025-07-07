package ru.cifra.academy.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cifra.academy.orderservice.dto.ClientRegistrationRequest;
import ru.cifra.academy.orderservice.entity.Client;
import ru.cifra.academy.orderservice.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client registerClient(ClientRegistrationRequest request) {
        clientRepository.findByPhoneNumber(request.getPhoneNumber()).ifPresent(client -> {
            throw new RuntimeException("User with phone number already exists");
        });

        Client client = new Client();
        client.setName(request.getName());
        client.setPhoneNumber(request.getPhoneNumber());

        return clientRepository.save(client);
    }
}
