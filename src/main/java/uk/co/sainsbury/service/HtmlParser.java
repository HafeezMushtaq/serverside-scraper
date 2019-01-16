package uk.co.sainsbury.service;

import java.util.List;

public interface HtmlParser {

    List<Product> parse(String url);
}
