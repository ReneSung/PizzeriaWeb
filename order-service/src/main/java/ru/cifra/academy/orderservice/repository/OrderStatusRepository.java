package ru.cifra.academy.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cifra.academy.orderservice.entity.OrderStatus;

import java.util.Optional;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
    Optional<OrderStatus> findByCode(String code);

    boolean existsByCode(String code);
}
