package uk.co.sainsbury.service;

import uk.co.sainsbury.model.ProductInformation;
import uk.co.sainsbury.utility.Product;

import java.util.List;

public class ProductInformationConverter {

    public ProductInformation convert(List<Product> products) {
        return new ProductInformation(null, null);
    }
}
