package uk.co.sainsbury.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class DisplayProduct {

    @SerializedName("title")
    private final String title;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @SerializedName("kcal_per_100g")
    private final Integer energy;

    @SerializedName("unit_price")
    private final BigDecimal price;

    @SerializedName("description")
    private final String description;

    public DisplayProduct(String title, Integer energy, BigDecimal price, String description) {
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

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
