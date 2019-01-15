package uk.co.sainsbury;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

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
    public void parse_shouldUseDocumentExtractorToExtractTheProductElements() {
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
    public void parse_shouldUseDocumentExtractorToExtractTheTitleOfProduct() {
        Document document = new Document(URL);
        when(jsoupApi.getWebPageAsDocument(anyString())).thenReturn(document);
        Element element = new Element("element");
        Elements elements = new Elements(element);

        when(documentExtractor.getProductElements(any(Document.class))).thenReturn(elements);
        when(documentExtractor.getTitle(any(Element.class))).thenReturn("Cherries");

        parser.parse(URL);

        verify(jsoupApi).getWebPageAsDocument(URL);
        verify(documentExtractor).getTitle(element);
    }

    @Test
    public void parse_shouldUseDocumentExtractorToExtractTheEnergyValueOfProduct() {
        Document document = new Document(URL);
        when(jsoupApi.getWebPageAsDocument(anyString())).thenReturn(document);
        Element element = new Element("element");
        Elements elements = new Elements(element);

        when(documentExtractor.getProductElements(any(Document.class))).thenReturn(elements);
        when(documentExtractor.getEnergy(any(Element.class))).thenReturn(45);

        parser.parse(URL);

        verify(jsoupApi).getWebPageAsDocument(URL);
        verify(documentExtractor).getEnergy(element);
    }

    @Test
    public void parse_shouldUseDocumentExtractorToExtractTheDescriptionOfProduct() {
        Document document = new Document(URL);
        when(jsoupApi.getWebPageAsDocument(anyString())).thenReturn(document);
        Element element = new Element("element");
        Elements elements = new Elements(element);

        when(documentExtractor.getProductElements(any(Document.class))).thenReturn(elements);
        when(documentExtractor.getDescription(any(Element.class))).thenReturn("Really tasty");

        parser.parse(URL);

        verify(jsoupApi).getWebPageAsDocument(URL);
        verify(documentExtractor).getDescription(element);
    }

    @Test
    public void parse_shouldUseDocumentExtractorToExtractThePriceOfProduct() {
        Document document = new Document(URL);
        when(jsoupApi.getWebPageAsDocument(anyString())).thenReturn(document);
        Element element = new Element("element");
        Elements elements = new Elements(element);

        when(documentExtractor.getProductElements(any(Document.class))).thenReturn(elements);
        when(documentExtractor.getPrice(any(Element.class))).thenReturn(BigDecimal.ONE);

        parser.parse(URL);

        verify(jsoupApi).getWebPageAsDocument(URL);
        verify(documentExtractor).getPrice(element);
    }
}