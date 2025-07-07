package ru.cifra.academy.orderservice.component;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.cifra.academy.orderservice.dto.DishDTO;

import java.math.BigDecimal;

@Component
public class DishInfoProvider {
    private final RestTemplate restTemplate = new RestTemplate();

    public BigDecimal getDishPrice(Long dishId) {
        String url = "http://localhost:8080/api/dishes/" + dishId;
        DishDTO dish = restTemplate.getForObject(url, DishDTO.class);
        return dish.getPrice();
    }

    public String getDishName(Long dishId) {
        String url = "http://localhost:8080/api/dishes/" + dishId;
        DishDTO dish = restTemplate.getForObject(url, DishDTO.class);
        return dish.getName();
    }
}
