package uk.co.sainsbury.converter;

import uk.co.sainsbury.model.DisplayProduct;
import uk.co.sainsbury.model.ProductInformation;
import uk.co.sainsbury.usecase.Total;
import uk.co.sainsbury.utility.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProductInformationConverter implements Converter<List<Product>, ProductInformation> {

    public ProductInformation convert(List<Product> products) {
        List<DisplayProduct> displayProducts = products.stream()
                .map(product -> new DisplayProduct(product.getTitle(), product.getEnergy(), product.getPrice(), product.getDescription()))
                .collect(Collectors.toList());

        BigDecimal gross = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal grossWithoutVat = gross.divide(new BigDecimal("1.20"), 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal vat = gross.subtract(grossWithoutVat);

        return new ProductInformation(displayProducts, new Total(gross, vat));
    }
}
