package ru.cifra.academy.menuservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cifra.academy.menuservice.entity.Dish;
import ru.cifra.academy.menuservice.entity.Kitchen;

import java.math.BigDecimal;

public class DishDTO {
    private Long id;
    private String name;
    private BigDecimal price;

    public DishDTO(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public DishDTO(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
