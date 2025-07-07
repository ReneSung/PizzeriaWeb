package ru.cifra.academy.menuservice.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cifra.academy.menuservice.dto.DishDTO;
import ru.cifra.academy.menuservice.dto.DishRequest;
import ru.cifra.academy.menuservice.dto.KitchenDTO;
import ru.cifra.academy.menuservice.entity.Dish;
import ru.cifra.academy.menuservice.entity.Kitchen;
import ru.cifra.academy.menuservice.repository.DishRepository;
import ru.cifra.academy.menuservice.service.DishService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dishes")
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;
    private final DishRepository dishRepository;

    @PostMapping
    public ResponseEntity<Dish> addDish(@RequestBody DishRequest dishRequest) {
        return ResponseEntity.ok(dishService.saveDish(dishRequest));
    }

    /*@GetMapping
    public ResponseEntity<List<Dish>> getAllDishes() {
        return ResponseEntity.ok(dishService.getAllDishes());
    }*/

    @GetMapping
    public ResponseEntity<List<DishDTO>> getDishes() {
        return ResponseEntity.ok(dishService.getSimpleDishList());
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<DishDTO> getDishById(@PathVariable Long id) {
        return dishRepository.findById(id)
                .map(dish -> ResponseEntity.ok(new DishDTO(dish.getId(), dish.getName(), dish.getPrice())))
                .orElse(ResponseEntity.notFound().build());
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<DishDTO> getDishById(@PathVariable Long id) {
        DishDTO dish = dishService.getDishById(id);
        return ResponseEntity.ok(dish);
    }
}
