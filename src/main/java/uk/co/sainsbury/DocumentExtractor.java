package uk.co.sainsbury;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.math.BigDecimal;

public class DocumentExtractor {

    public Elements getProductElements(Document document) {
        return document.select(".productLister .gridItem");
    }

    public String getTitle(Element element) {
        return element.selectFirst("a").text();
    }

    public BigDecimal getPrice(Element element) {
        String price = element.selectFirst(".pricing .pricePerUnit").text();
        return new BigDecimal(price);
    }

    public Elements getProductInformation(Element element) {
        return null;
    }

    public String getDescription(Elements productInfo) {
        return productInfo.get(0).selectFirst("p").text();

    }

    public Integer getEnergy(Elements productInfo) {
        Element energyElement = productInfo.get(1).selectFirst(".nutritionTable");

        String energy = energyElement.select("tbody tr").get(1).selectFirst("td").text();
        return Integer.parseInt(energy.replace("kcal", ""));
    }

}
