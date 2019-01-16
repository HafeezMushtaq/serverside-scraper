package uk.co.sainsbury;


import uk.co.sainsbury.api.JsoupApi;
import uk.co.sainsbury.service.*;
import uk.co.sainsbury.usecase.ScraperUseCase;

public class Main {

    private static final String URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";

    public static void main(String[] args) {

        JsoupApi jsoupApi = new JsoupApi();
        DocumentExtractor documentExtractor = new DocumentExtractor();
        HtmlParser parser = new JsoupHtmlParser(jsoupApi, documentExtractor);
        ScrapingService scrapingService = new ScrapingService(parser);
        ScraperUseCase useCase = new ScraperUseCase(scrapingService);
        System.out.println(useCase.scrape(URL));
    }
}
