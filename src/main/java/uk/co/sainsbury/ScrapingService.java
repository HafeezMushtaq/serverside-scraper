package uk.co.sainsbury;


public class ScrapingService {

    private final HtmlParser parser;

    public ScrapingService(HtmlParser parser) {
        this.parser = parser;
    }

    public String scrape(String url) {
        return String.valueOf(parser.parse(url));
    }
}
