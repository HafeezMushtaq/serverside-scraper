package uk.co.sainsbury;


public class Main {

    private static final String URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";

    public static void main(String[] args) {

        HtmlParser parser = url -> null;
        ScrapingService scrapingService = new ScrapingService(parser);
        ScraperUseCase useCase = new ScraperUseCase(scrapingService);
        System.out.println(useCase.scrape(URL));
    }
}
