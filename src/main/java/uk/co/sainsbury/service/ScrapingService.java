package uk.co.sainsbury.service;

import java.util.List;

public class ScrapingService {

    private final HtmlParser parser;

    public ScrapingService(HtmlParser parser) {
        this.parser = parser;
    }

    public List<Product> scrape(String url) {
        return parser.parse(url);
    }
}
