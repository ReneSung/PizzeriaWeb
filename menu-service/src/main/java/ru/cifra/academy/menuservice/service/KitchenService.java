package ru.cifra.academy.menuservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cifra.academy.menuservice.dto.KitchenRequest;
import ru.cifra.academy.menuservice.entity.Kitchen;
import ru.cifra.academy.menuservice.repository.KitchenRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KitchenService {
    private final KitchenRepository kitchenRepository;

    public Kitchen createKitchen(KitchenRequest request) {
        Kitchen kitchen = new Kitchen();
        kitchen.setName(request.getName());
        return kitchenRepository.save(kitchen);
    }

    public List<Kitchen> getAllKitchens() {
        return kitchenRepository.findAll();
    }
}
