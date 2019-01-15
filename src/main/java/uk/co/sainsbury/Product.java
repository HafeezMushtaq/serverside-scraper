package uk.co.sainsbury;

import java.math.BigDecimal;

public class Product {

    private final String title;
    private final Integer energy;
    private final BigDecimal price;
    private final String description;

    public Product(String title, Integer energy, BigDecimal price, String description) {
        this.title = title;
        this.energy = energy;
        this.price = price;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public Integer getEnergy() {
        return energy;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
