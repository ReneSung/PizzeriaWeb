package ru.cifra.academy.orderservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientRegistrationRequest {
    private String name;
    private String phoneNumber;
}
