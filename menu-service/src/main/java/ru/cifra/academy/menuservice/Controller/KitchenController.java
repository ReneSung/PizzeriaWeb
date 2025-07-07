package ru.cifra.academy.menuservice.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cifra.academy.menuservice.dto.KitchenRequest;
import ru.cifra.academy.menuservice.entity.Kitchen;
import ru.cifra.academy.menuservice.service.KitchenService;

import java.util.List;

@RestController
@RequestMapping("/api/kitchens")
@RequiredArgsConstructor
public class KitchenController {
    private final KitchenService kitchenService;

    @PostMapping
    public ResponseEntity<Kitchen> create(@RequestBody KitchenRequest request) {
        return ResponseEntity.ok(kitchenService.createKitchen(request));
    }

    @GetMapping
    public ResponseEntity<List<Kitchen>> getAll() {
        return ResponseEntity.ok(kitchenService.getAllKitchens());
    }
}
