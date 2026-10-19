package org.formation.catalog;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.formation.catalog.internal.CoffeeEntity;
import org.formation.catalog.internal.CoffeeRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Catalog {
    private final CoffeeRepository repository;
    private final ApplicationEventPublisher events;

    @Transactional
    public Long createCoffee(String name, int price) {
        CoffeeEntity saved = repository.save(new CoffeeEntity(name, price));
        events.publishEvent(new CoffeeCreated(saved.getId(), saved.getName()));
        return saved.getId();
    }
}