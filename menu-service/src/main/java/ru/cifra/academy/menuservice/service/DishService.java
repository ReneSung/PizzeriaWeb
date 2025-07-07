package ru.cifra.academy.menuservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.cifra.academy.menuservice.dto.DishDTO;
import ru.cifra.academy.menuservice.dto.DishRequest;
import ru.cifra.academy.menuservice.entity.Dish;
import ru.cifra.academy.menuservice.entity.Kitchen;
import ru.cifra.academy.menuservice.repository.DishRepository;
import ru.cifra.academy.menuservice.repository.KitchenRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;
    private final KitchenRepository kitchenRepository;

    public Dish saveDish(DishRequest dishRequest) {
        Optional<Kitchen> kitchenOpt = kitchenRepository.findById(dishRequest.getKitchenId());
        if (kitchenOpt.isEmpty()) {
            throw new RuntimeException("Kitchen not found with id " + dishRequest.getKitchenId());
        }
        Kitchen kitchen = kitchenOpt.get();

        Dish dish = new Dish();
        dish.setName(dishRequest.getName());
        dish.setPrice(dishRequest.getPrice());
        dish.setKitchen(kitchen);

        return dishRepository.save(dish);
    }

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public List<DishDTO> getSimpleDishList() {
        return dishRepository.findAllDishNamesAndPrices();
    }

    public DishDTO getDishById(Long id) {
        return dishRepository.findDishDTOById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found with id: " + id));
    }

}
