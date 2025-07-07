package ru.cifra.academy.menuservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DishRequest {
    private String name;
    private BigDecimal price;
    private int kitchenId;
}
