package org.formation.inventory.internal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Long coffeeId;

    private int quantity;

    protected StockEntity() {}
    public StockEntity(Long coffeeId, int quantity) { this.coffeeId = coffeeId; this.quantity = quantity; }
    public Long getCoffeeId() { return coffeeId; }
}
