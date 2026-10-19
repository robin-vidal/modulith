package org.formation.catalog;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coffees")
@RequiredArgsConstructor
class CatalogController {
    private final Catalog catalog;

    @PostMapping
    ResponseEntity<Long> create(@Valid @RequestBody CreateCoffeeRequest request) {
        Long id = catalog.createCoffee(request.name(), request.price());
        return ResponseEntity.status(201).body(id);
    }
}
