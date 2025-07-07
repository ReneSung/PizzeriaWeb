package ru.cifra.academy.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cifra.academy.orderservice.dto.ClientRegistrationRequest;
import ru.cifra.academy.orderservice.dto.OrderStatusRequest;
import ru.cifra.academy.orderservice.entity.Client;
import ru.cifra.academy.orderservice.entity.OrderStatus;
import ru.cifra.academy.orderservice.service.ClientService;
import ru.cifra.academy.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final OrderService orderService;

    @PostMapping("/register")
    public ResponseEntity<Client> register(@RequestBody ClientRegistrationRequest request) {
        Client client = clientService.registerClient(request);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/status")
    public ResponseEntity<OrderStatus> createOrderStatus(@RequestBody OrderStatusRequest request) {
        return ResponseEntity.ok(orderService.createStatus(request));
    }
}
