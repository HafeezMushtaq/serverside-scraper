package uk.co.sainsbury.service;

import uk.co.sainsbury.api.JsoupException;
import uk.co.sainsbury.converter.Converter;
import uk.co.sainsbury.model.ProductInformation;
import uk.co.sainsbury.utility.HtmlParser;
import uk.co.sainsbury.utility.Product;

import java.util.List;

public class ScrapingService {

    private final HtmlParser parser;
    private final Converter<List<Product>, ProductInformation> converter;

    public ScrapingService(final HtmlParser parser, final Converter converter) {
        this.parser = parser;
        this.converter = converter;
    }

    public ProductInformation scrape(final String url) throws JsoupException {
        final List<Product> products = parser.parse(url);
        return converter.convert(products);
    }
}
