package uk.co.sainsbury;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class DocumentExtractorTest {

    private DocumentExtractor extractor = new DocumentExtractor();

    @Test
    public void getProductElements_ShouldUseSelectWithCssQueryToExtractProductElements() {
        Document document = mock(Document.class);

        extractor.getProductElements(document);
        verify(document).select(".productLister .gridItem");
    }

    @Test
    public void getTitle_ShouldUseSelectFirstWithCssQueryToExtractTitleOfElement() {
        Element element = mock(Element.class);
        when(element.selectFirst(anyString())).thenReturn(new Element("title"));

        extractor.getTitle(element);

        verify(element).selectFirst("a");
    }

    @Test
    public void getPrice_ShouldUseSelectFirstWithCssQueryToExtractDescriptionFromOfProductInfo() {
        Element element = mock(Element.class);
        Element price = mock(Element.class);
        when(element.selectFirst(anyString())).thenReturn(price);
        when(price.text()).thenReturn("12.45");

        assertThat(extractor.getPrice(element)).isEqualTo(new BigDecimal("12.45"));
        verify(element).selectFirst(".pricing .pricePerUnit");
    }

    @Test
    public void getPrice_ShouldRemoveStripOutTheExtraTextFromThePriceText() {
        Element element = mock(Element.class);
        Element price = mock(Element.class);
        when(element.selectFirst(anyString())).thenReturn(price);
        when(price.text()).thenReturn("£12.45/unit");

        assertThat(extractor.getPrice(element)).isEqualTo(new BigDecimal("12.45"));
        verify(element).selectFirst(".pricing .pricePerUnit");
    }

    @Test
    public void getProductInformationUrl_shouldUseSelectFirstWithCssQueryToExtractProductInfoUrl() {
        Element element = mock(Element.class);
        Element productInfoUrl = mock(Element.class);
        when(element.selectFirst(anyString())).thenReturn(productInfoUrl);
        when(productInfoUrl.attr(anyString())).thenReturn("www.product-info/url");

        assertThat(extractor.getProductInformationUrl(element)).isEqualTo("www.product-info/url");
        verify(element).selectFirst("a");
    }

    @Test
    public void getProductInformation_shouldUseSelectFirstWithCssQueryToExtractProductInfoUrl() {
        Document prodInfoDoc = mock(Document.class);
        Elements prodInfo = mock(Elements.class);
        when(prodInfoDoc.select(anyString())).thenReturn(prodInfo);
        when(prodInfo.attr(anyString())).thenReturn("www.product-info/url");

        assertThat(extractor.getProductInformation(prodInfoDoc)).isEqualTo(prodInfo);
        verify(prodInfoDoc).select("#information .productText");
    }

    @Test
    public void getDescription_ShouldUseSelectFirstWithCssQueryToExtractDescriptionFromOfProductInfo() {
        Elements productInfo = mock(Elements.class);
        Element description = mock(Element.class);
        when(productInfo.get(0)).thenReturn(description);
        when(description.selectFirst(anyString())).thenReturn(new Element("productInfo"));

        extractor.getDescription(productInfo);

        verify(productInfo.get(0)).selectFirst("p");
    }

    @Test
    public void getEnergy_ShouldUseSelectWithCssQueryToExtractTheEnergyValueWithoutUnits() {
        Elements productInfo = mock(Elements.class);
        Element productInfoRows = mock(Element.class);
        Element nutritionTable = mock(Element.class);
        Elements nutritionRows = mock(Elements.class);
        Element energyRow = mock(Element.class);
        Element energy = mock(Element.class);

        when(productInfo.get(1)).thenReturn(productInfoRows);
        when(productInfoRows.selectFirst(anyString())).thenReturn(nutritionTable);

        when(nutritionTable.select(anyString())).thenReturn(nutritionRows);
        when(nutritionRows.get(1)).thenReturn(energyRow);
        when(energyRow.selectFirst(anyString())).thenReturn(energy);
        when(energy.text()).thenReturn("100kcal");

        assertThat(extractor.getEnergy(productInfo)).isEqualTo(100);
        verify(productInfoRows).selectFirst(".nutritionTable");
        verify(nutritionTable).select("tbody tr");
        verify(energyRow).selectFirst("td");
    }

    @Test
    public void getEnergy_shouldReturnNullIfEnergyElementIsNotPresent() {
        Elements productInfo = mock(Elements.class);
        Element productInfoRows = mock(Element.class);

        when(productInfo.get(1)).thenReturn(productInfoRows);
        when(productInfoRows.selectFirst(anyString())).thenReturn(null);

        assertThat(extractor.getEnergy(productInfo)).isNull();
        verify(productInfoRows).selectFirst(".nutritionTable");
    }
}