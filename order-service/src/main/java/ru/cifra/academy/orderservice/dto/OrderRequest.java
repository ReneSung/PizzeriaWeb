package ru.cifra.academy.orderservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private Long clientId;
    private List<OrderItemRequest> items;
}
