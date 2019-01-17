package uk.co.sainsbury.usecase;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import uk.co.sainsbury.api.JsoupException;
import uk.co.sainsbury.model.ProductInformation;
import uk.co.sainsbury.service.ScrapingService;


public class ScraperUseCase {

    private final ScrapingService scrapingService;

    public ScraperUseCase(ScrapingService scrapingService) {
        this.scrapingService = scrapingService;
    }

    public JsonElement scrape(String url)  {
        try {
            ProductInformation productInformation = scrapingService.scrape(url);
            Gson gson = new Gson();
            return gson.toJsonTree(productInformation);
        } catch (JsoupException e) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("error", new JsonPrimitive(String.format("Please check URL - Could not connect to [%s]", url)));
            return  jsonObject;
        }
    }
}
