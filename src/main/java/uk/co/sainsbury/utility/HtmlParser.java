package uk.co.sainsbury.utility;

import java.util.List;

public interface HtmlParser {

    List<Product> parse(String url);
}
