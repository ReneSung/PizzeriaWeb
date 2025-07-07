package ru.cifra.academy.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cifra.academy.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
