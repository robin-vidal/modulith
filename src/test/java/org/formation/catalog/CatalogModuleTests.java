package org.formation.catalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest
class CatalogModuleTests {
    @Autowired
    Catalog catalog;

    @Test
    void publishesCoffeeCreatedOnCreate(Scenario scenario) {
        scenario.stimulate(() -> catalog.createCoffee("Espresso", new BigDecimal("2.50")))
                .andWaitForEventOfType(CoffeeCreated.class)
                .toArriveAndVerify(event -> assertThat(event.name()).isEqualTo("Espresso"));
    }
}
