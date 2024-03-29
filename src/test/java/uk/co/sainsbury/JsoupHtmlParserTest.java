package uk.co.sainsbury;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.sainsbury.api.JsoupException;
import uk.co.sainsbury.utility.DocumentExtractor;
import uk.co.sainsbury.api.JsoupApi;
import uk.co.sainsbury.utility.JsoupHtmlParser;
import uk.co.sainsbury.utility.Product;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JsoupHtmlParserTest {

    private static final String URL = "localhost:80/scrape";

    @Mock
    private JsoupApi jsoupApi;

    @Mock
    private DocumentExtractor documentExtractor;


    @InjectMocks
    private JsoupHtmlParser parser;

    @Test
    public void parse_shouldUseDocumentExtractorToExtractTheProductElements() throws JsoupException {
        Document document = new Document(URL);
        when(jsoupApi.getWebPageAsDocument(anyString())).thenReturn(document);
        Element element = new Element("element");
        Elements elements = new Elements(element);

        when(documentExtractor.getProductElements(any(Document.class))).thenReturn(elements);

        parser.parse(URL);

        verify(jsoupApi).getWebPageAsDocument(URL);
        verify(documentExtractor).getProductElements(document);
    }

    @Test
    public void parse_shouldUseDocumentExtractorToExtractTheTitleOfProduct() throws JsoupException {
        Document document = new Document(URL);
        when(jsoupApi.getWebPageAsDocument(anyString())).thenReturn(document);
        Element element = new Element("element");
        Elements elements = new Elements(element);

        when(documentExtractor.getProductElements(any(Document.class))).thenReturn(elements);
        when(documentExtractor.getTitle(any(Element.class))).thenReturn("Cherries");

        assertThat(parser.parse(URL).get(0).getTitle()).isEqualTo("Cherries");
        verify(jsoupApi).getWebPageAsDocument(URL);
        verify(documentExtractor).getTitle(element);
    }

    @Test
    public void parse_shouldUseDocumentExtractorToExtractTheEnergyValueOfProduct() throws JsoupException {
        Document document = new Document(URL);
        Element element = new Element("element");
        Elements elements = new Elements(element);
        Elements productInformation = new Elements(new Element("product"), new Element("information"));

        when(jsoupApi.getWebPageAsDocument(anyString())).thenReturn(document);
        when(documentExtractor.getProductElements(any(Document.class))).thenReturn(elements);
        when(documentExtractor.getProductInformation(any(Document.class))).thenReturn(productInformation);
        when(documentExtractor.getEnergy(any(Elements.class))).thenReturn(45);

        assertThat(parser.parse(URL).get(0).getEnergy()).isEqualTo(45);
        verify(jsoupApi).getWebPageAsDocument(URL);
        verify(documentExtractor).getProductInformation(document);
        verify(documentExtractor).getEnergy(productInformation);
    }

    @Test
    public void parse_shouldUseDocumentExtractorToExtractTheDescriptionOfProduct() throws JsoupException {
        Document document = new Document(URL);
        Element element = new Element("element");
        Elements elements = new Elements(element);
        Elements productInformation = new Elements(new Element("product"), new Element("information"));

        when(jsoupApi.getWebPageAsDocument(anyString())).thenReturn(document);
        when(documentExtractor.getProductElements(any(Document.class))).thenReturn(elements);
        when(documentExtractor.getProductInformation(any(Document.class))).thenReturn(productInformation);
        when(documentExtractor.getDescription(any(Elements.class))).thenReturn("Really tasty");

        assertThat(parser.parse(URL).get(0).getDescription()).isEqualTo("Really tasty");
        verify(jsoupApi).getWebPageAsDocument(URL);
        verify(documentExtractor).getProductInformation(document);
        verify(documentExtractor).getDescription(productInformation);
    }

    @Test
    public void parse_shouldUseDocumentExtractorToExtractThePriceOfProduct() throws JsoupException {
        Document document = new Document(URL);
        when(jsoupApi.getWebPageAsDocument(anyString())).thenReturn(document);
        Element element = new Element("element");
        Elements elements = new Elements(element);

        when(documentExtractor.getProductElements(any(Document.class))).thenReturn(elements);
        when(documentExtractor.getPrice(any(Element.class))).thenReturn(BigDecimal.ONE);

        assertThat(parser.parse(URL).get(0).getPrice()).isEqualTo(BigDecimal.ONE);

        verify(jsoupApi).getWebPageAsDocument(URL);
        verify(documentExtractor).getPrice(element);
    }

    @Test
    public void parse_ReturnListOfProductsWhenWeHaveMoreThanProductElement() throws JsoupException {
        Document document = new Document(URL);
        when(jsoupApi.getWebPageAsDocument(anyString())).thenReturn(document);
        Element element = new Element("element");
        Element anotherElement = new Element("element");
        Elements elements = new Elements(element, anotherElement);
        Elements productInformation = new Elements(new Element("product"), new Element("information"));

        when(documentExtractor.getProductElements(any(Document.class))).thenReturn(elements);
        when(documentExtractor.getTitle(any(Element.class))).thenReturn("Mangoes", "Apples");
        when(documentExtractor.getEnergy(any(Elements.class))).thenReturn(185, 105);
        when(documentExtractor.getProductInformation(any(Document.class))).thenReturn(productInformation);
        when(documentExtractor.getDescription(any(Elements.class))).thenReturn("Refreshing", "Crisp");
        when(documentExtractor.getPrice(any(Element.class))).thenReturn(new BigDecimal("1.20"), new BigDecimal("65"));

        List<Product> products = parser.parse(URL);

        assertThat(products.get(0)).isEqualTo(new Product("Mangoes", 185, new BigDecimal("1.20"), "Refreshing"));
        assertThat(products.get(1)).isEqualTo(new Product("Apples", 105, new BigDecimal("65"), "Crisp")       );
    }
}