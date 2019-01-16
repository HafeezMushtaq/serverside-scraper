package uk.co.sainsbury.usecase;

import uk.co.sainsbury.service.Product;
import uk.co.sainsbury.service.ScrapingService;

import java.util.List;

public class ScraperUseCase {

    private final ScrapingService scrapingService;

    public ScraperUseCase(ScrapingService scrapingService) {
        this.scrapingService = scrapingService;
    }

    public ProductInformation scrape(String url) {
        List<Product> products = scrapingService.scrape(url);
        return new ProductInformation(null, null);
    }
}
