package ru.cifra.academy.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cifra.academy.orderservice.component.DishInfoProvider;
import ru.cifra.academy.orderservice.dto.OrderRequest;
import ru.cifra.academy.orderservice.dto.OrderStatusRequest;
import ru.cifra.academy.orderservice.entity.Client;
import ru.cifra.academy.orderservice.entity.Order;
import ru.cifra.academy.orderservice.entity.OrderItem;
import ru.cifra.academy.orderservice.entity.OrderStatus;
import ru.cifra.academy.orderservice.repository.ClientRepository;
import ru.cifra.academy.orderservice.repository.OrderRepository;
import ru.cifra.academy.orderservice.repository.OrderStatusRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final OrderStatusRepository statusRepository;
    private final DishInfoProvider dishInfoProvider;

    public Order createOrder(OrderRequest request) {
        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        OrderStatus status = statusRepository.findByCode("created")
                .orElseThrow(() -> new RuntimeException("Status not found"));

        Order order = new Order();
        order.setClient(client);
        order.setStatus(status);

        List<OrderItem> items = request.getItems().stream().map(itemRequest -> {
            BigDecimal price = dishInfoProvider.getDishPrice(itemRequest.getDishId());
            String dishName = dishInfoProvider.getDishName(itemRequest.getDishId());

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setDishId(itemRequest.getDishId());
            item.setDishName(dishName);
            item.setAmount(itemRequest.getAmount());
            item.setPrice(price);
            return item;
        }).toList();

        order.setItems(items);
        return orderRepository.save(order);
    }

    public OrderStatus createStatus(OrderStatusRequest request) {
        if (statusRepository.existsByCode(request.getCode())) {
            throw new RuntimeException("Status with code '" + request.getCode() + "' already exists");
        }

        OrderStatus status = new OrderStatus();
        status.setCode(request.getCode());
        status.setStatus(request.getStatus());
        return statusRepository.save(status);
    }

}
