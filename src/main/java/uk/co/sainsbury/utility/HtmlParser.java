package uk.co.sainsbury.utility;

import uk.co.sainsbury.api.JsoupException;

import java.util.List;

public interface HtmlParser {

    List<Product> parse(final String url) throws JsoupException;
}
