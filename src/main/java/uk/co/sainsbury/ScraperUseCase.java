package uk.co.sainsbury;

public class ScraperUseCase {

    private final ScrapingService scrapingService;

    public ScraperUseCase(ScrapingService scrapingService) {
        this.scrapingService = scrapingService;
    }

    public String scrape(String url) {
        return scrapingService.scrape(url);
    }
}
