package uk.co.sainsbury.api;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupApi {

    public Document getWebPageAsDocument(final String url) throws JsoupException {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new JsoupException("Unable to connect to the supplied URL");
        }
    }
}
