package uk.co.sainsbury.service;

import uk.co.sainsbury.model.ProductInformation;
import uk.co.sainsbury.utility.HtmlParser;
import uk.co.sainsbury.utility.Product;

import java.util.List;

public class ScrapingService {

    private final HtmlParser parser;
    private final ProductInformationConverter converter;

    public ScrapingService(HtmlParser parser, ProductInformationConverter converter) {
        this.parser = parser;
        this.converter = converter;
    }

    public ProductInformation scrape(String url) {
        List<Product> products = parser.parse(url);
        return converter.convert(products);
    }
}
