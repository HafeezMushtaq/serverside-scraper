package uk.co.sainsbury;

import java.util.List;

public interface HtmlParser {

    List<Product> parse(String url);
}
