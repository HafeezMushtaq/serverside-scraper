package uk.co.sainsbury.usecase;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class ProductInformation {

    private final List<DisplayProduct> products;
    private final Total total;

    public ProductInformation(List<DisplayProduct> products, Total total) {
        this.products = products;
        this.total = total;
    }

    public List<DisplayProduct> getProducts() {
        return products;
    }

    public Total getTotal() {
        return total;
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
