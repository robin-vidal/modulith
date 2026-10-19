package org.formation.catalog;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record CreateCoffeeRequest(
        @NotBlank String name,
        @Positive BigDecimal price
) {}
