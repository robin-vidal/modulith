package org.formation.inventory.internal;

import lombok.RequiredArgsConstructor;
import org.formation.catalog.CoffeeCreated;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class InventoryListener {
    private final StockRepository repository;

    @ApplicationModuleListener
    void on(CoffeeCreated event) {
        if (!repository.existsByCoffeeId(event.coffeeId())) {
            repository.save(new StockEntity(event.coffeeId(), 0));
        }
    }
}
