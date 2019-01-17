package uk.co.sainsbury;

import org.junit.Test;
import uk.co.sainsbury.converter.ProductInformationConverter;
import uk.co.sainsbury.model.DisplayProduct;
import uk.co.sainsbury.model.ProductInformation;
import uk.co.sainsbury.utility.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

public class ProductInformationConverterTest {

    private final ProductInformationConverter converter = new ProductInformationConverter();

    @Test
    public void convert_shouldConvertTheProductIntoDisplayProductOnProductInfo() {
        Product product = new Product("Kiwi", 325, BigDecimal.TEN, "Healthy Stuff");
        DisplayProduct displayProduct = new DisplayProduct("Kiwi", 325, BigDecimal.TEN, "Healthy Stuff");

        ProductInformation result = converter.convert(Collections.singletonList(product));

        assertThat(result.getProducts()).containsOnly(displayProduct);
    }

    @Test
    public void convert_shouldConvertTheProductsIntoDisplayProductsOnProductInfo() {
        Product product = new Product("Kiwi", 325, BigDecimal.TEN, "Healthy Stuff");
        Product product2 = new Product("Banana", 650, BigDecimal.ONE, "Awesome");
        DisplayProduct displayProduct = new DisplayProduct("Kiwi", 325, BigDecimal.TEN, "Healthy Stuff");
        DisplayProduct displayProduct2 = new DisplayProduct("Banana", 650, BigDecimal.ONE, "Awesome");

        ProductInformation result = converter.convert(Arrays.asList(product, product2));

        assertThat(result.getProducts()).contains(displayProduct, displayProduct2);
    }

    @Test
    public void convert_shouldCalculateTheCorrectProductTotals() {
        Product product = new Product("Kiwi", 325, new BigDecimal("1.25"), "Healthy Stuff");
        Product product2 = new Product("Banana", 650, new BigDecimal("2.55"), "Awesome");
        DisplayProduct displayProduct = new DisplayProduct("Kiwi", 325, new BigDecimal("1.25"), "Healthy Stuff");
        DisplayProduct displayProduct2 = new DisplayProduct("Banana", 650, new BigDecimal("2.55"), "Awesome");

        ProductInformation result = converter.convert(Arrays.asList(product, product2));

        assertThat(result.getProducts()).contains(displayProduct, displayProduct2);
        assertThat(result.getTotal().getGross()).isEqualTo("3.80");
        assertThat(result.getTotal().getVat()).isEqualTo("0.63");
    }
}