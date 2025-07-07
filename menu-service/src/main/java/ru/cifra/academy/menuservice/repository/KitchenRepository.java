package ru.cifra.academy.menuservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cifra.academy.menuservice.entity.Kitchen;

public interface KitchenRepository  extends JpaRepository<Kitchen, Integer> {
}
