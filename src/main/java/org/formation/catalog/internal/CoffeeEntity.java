package org.formation.catalog.internal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
public class CoffeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    protected CoffeeEntity() {}
    public CoffeeEntity(String name, BigDecimal price) { this.name = name; this.price = price; }
    public Long getId() { return id; }
    public String getName() { return name; }
}
