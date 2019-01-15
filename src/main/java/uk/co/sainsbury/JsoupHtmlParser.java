package uk.co.sainsbury;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.math.BigDecimal;

public class JsoupHtmlParser implements HtmlParser {

    private final JsoupApi jsoupApi;
    private final DocumentExtractor documentExtractor;

    public JsoupHtmlParser(JsoupApi jsoupApi, DocumentExtractor documentExtractor) {
        this.jsoupApi = jsoupApi;
        this.documentExtractor = documentExtractor;
    }

    @Override
    public Object parse(String url) {
        Document document = jsoupApi.getWebPageAsDocument(url);
        Element element = documentExtractor.getProductElements(document).get(0);

        String title = documentExtractor.getTitle(element);
        BigDecimal unitPrice = documentExtractor.getPrice(element);
        Elements productInformation = documentExtractor.getProductInformation(element);
        String description = documentExtractor.getDescription(element);
        Integer energy = documentExtractor.getEnergy(element);


        return document;
    }
}
