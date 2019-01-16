package uk.co.sainsbury.usecase;

import uk.co.sainsbury.service.ScrapingService;

public class ScraperUseCase {

    private final ScrapingService scrapingService;

    public ScraperUseCase(ScrapingService scrapingService) {
        this.scrapingService = scrapingService;
    }

    public String scrape(String url) {
        return scrapingService.scrape(url);
    }
}
