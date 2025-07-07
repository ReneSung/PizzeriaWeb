package ru.cifra.academy.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cifra.academy.orderservice.dto.OrderRequest;
import ru.cifra.academy.orderservice.dto.OrderStatusRequest;
import ru.cifra.academy.orderservice.entity.Order;
import ru.cifra.academy.orderservice.entity.OrderStatus;
import ru.cifra.academy.orderservice.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest request) {
        Order order = orderService.createOrder(request);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderService.findAl());
    }
}
