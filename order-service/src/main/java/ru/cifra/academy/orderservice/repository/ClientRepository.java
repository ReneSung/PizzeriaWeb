package ru.cifra.academy.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cifra.academy.orderservice.entity.Client;

import java.util.Optional;

public interface  ClientRepository  extends JpaRepository<Client, Long> {
    Optional<Client> findByPhoneNumber(String phoneNumber);
}
