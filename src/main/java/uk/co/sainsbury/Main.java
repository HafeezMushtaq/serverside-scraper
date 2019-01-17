package uk.co.sainsbury;


import uk.co.sainsbury.api.JsoupApi;
import uk.co.sainsbury.converter.Converter;
import uk.co.sainsbury.converter.ProductInformationConverter;
import uk.co.sainsbury.service.*;
import uk.co.sainsbury.utility.DocumentExtractor;
import uk.co.sainsbury.utility.HtmlParser;
import uk.co.sainsbury.utility.JsoupHtmlParser;
import uk.co.sainsbury.usecase.ScraperUseCase;

public class Main {

    private static final String URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";

    public static void main(String[] args) {

        final JsoupApi jsoupApi = new JsoupApi();
        final DocumentExtractor documentExtractor = new DocumentExtractor();
        final HtmlParser parser = new JsoupHtmlParser(jsoupApi, documentExtractor);
        final Converter converter = new ProductInformationConverter();
        final ScrapingService scrapingService = new ScrapingService(parser, converter);
        final ScraperUseCase useCase = new ScraperUseCase(scrapingService);
        System.out.println(useCase.scrape(URL));
    }
}
