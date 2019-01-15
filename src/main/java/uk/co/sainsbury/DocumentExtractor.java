package uk.co.sainsbury;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.math.BigDecimal;

public class DocumentExtractor {

    public Elements getProductElements(Document document) {
        return new Elements(new Element("dummy"));
    }

    public String getTitle(Element element) {
        return null;
    }

    public BigDecimal getPrice(Element element) {
        return null;
    }

    public Elements getProductInformation(Element element) {
        return null;
    }

    public String getDescription(Element element) {
        return null;
    }

    public Integer getEnergy(Element element) {
        return null;
    }

}
