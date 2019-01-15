package uk.co.sainsbury;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
        Elements productElements = documentExtractor.getProductElements(document);

        return document;
    }
}
