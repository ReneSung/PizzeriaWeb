package ru.cifra.academy.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cifra.academy.orderservice.dto.OrderStatusRequest;
import ru.cifra.academy.orderservice.entity.OrderStatus;
import ru.cifra.academy.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/administration")
@RequiredArgsConstructor
public class AdministrationController {
    private final OrderService orderService;
    @PostMapping("/status")
    public ResponseEntity<OrderStatus> createOrderStatus(@RequestBody OrderStatusRequest request) {
        return ResponseEntity.ok(orderService.createStatus(request));
    }
}
