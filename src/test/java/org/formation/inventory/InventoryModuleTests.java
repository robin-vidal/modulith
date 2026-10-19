package org.formation.inventory;

import org.formation.catalog.CoffeeCreated;
import org.formation.inventory.internal.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest
class InventoryModuleTests {
    @Autowired
    StockRepository stockRepository;

    @Autowired
    ApplicationEventPublisher publisher;

    @BeforeEach
    void setUp() {
        stockRepository.deleteAll();
    }

    @Test
    void createsStockOnCoffeeCreated(Scenario scenario) {
        scenario.publish(new CoffeeCreated(1L, "Espresso"))
                .andWaitForStateChange(() -> stockRepository.count())
                .andVerify(count -> assertThat(count).isEqualTo(1L));
    }

    @Test
    void idempotentOnDuplicateEvent(Scenario scenario) {
        var event = new CoffeeCreated(2L, "Latte");

        scenario.publish(event)
                .andWaitForStateChange(() -> stockRepository.existsByCoffeeId(2L))
                .andVerify(exists -> assertThat(exists).isTrue());

        publisher.publishEvent(event);
        assertThat(stockRepository.count()).isEqualTo(1L);
    }
}
