package ru.cifra.academy.menuservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.cifra.academy.menuservice.dto.DishDTO;
import ru.cifra.academy.menuservice.entity.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Long> {
    @Query("SELECT new ru.cifra.academy.menuservice.dto.DishDTO(d.id, d.name, d.price) FROM Dish d")
    List<DishDTO> findAllDishNamesAndPrices();

    @Query("SELECT new ru.cifra.academy.menuservice.dto.DishDTO(d.id, d.name, d.price) FROM Dish d WHERE d.id = :id")
    Optional<DishDTO> findDishDTOById(Long id);
}
