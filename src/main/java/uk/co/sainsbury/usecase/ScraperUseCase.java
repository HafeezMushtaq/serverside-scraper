package uk.co.sainsbury.usecase;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import uk.co.sainsbury.model.ProductInformation;
import uk.co.sainsbury.service.ScrapingService;


public class ScraperUseCase {

    private final ScrapingService scrapingService;

    public ScraperUseCase(ScrapingService scrapingService) {
        this.scrapingService = scrapingService;
    }

    public JsonElement scrape(String url) {
        ProductInformation productInformation = scrapingService.scrape(url);
        Gson gson = new Gson();
        return gson.toJsonTree(productInformation);
    }
}
