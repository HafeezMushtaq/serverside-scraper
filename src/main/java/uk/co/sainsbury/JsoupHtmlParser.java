package uk.co.sainsbury;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JsoupHtmlParser implements HtmlParser {

    private final JsoupApi jsoupApi;
    private final DocumentExtractor documentExtractor;

    public JsoupHtmlParser(JsoupApi jsoupApi, DocumentExtractor documentExtractor) {
        this.jsoupApi = jsoupApi;
        this.documentExtractor = documentExtractor;
    }

    @Override
    public List<Product> parse(String url) {
        Document document = jsoupApi.getWebPageAsDocument(url);
        Elements productElements = documentExtractor.getProductElements(document);
        List<Product> products = new ArrayList<>();

        for (Element element : productElements) {
            String title = documentExtractor.getTitle(element);
            BigDecimal unitPrice = documentExtractor.getPrice(element);
            Elements productInformation = documentExtractor.getProductInformation(element);
            String description = documentExtractor.getDescription(element);
            Integer energy = documentExtractor.getEnergy(element);

            products.add(new Product(title, energy, unitPrice, description));
        }
        return products;
    }
}
