package uk.co.sainsbury;


public class Main {

    private static final String URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";

    public static void main(String[] args) {

        ScraperUseCase useCase = new ScraperUseCase();
        System.out.println(useCase.scrape(URL));
    }
}