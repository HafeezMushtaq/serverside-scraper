package uk.co.sainsbury;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JsoupHtmlParserTest {

    @Mock
    private JsoupApi jsoupApi;

    @Mock
    private DocumentExtractor documentExtractor;


    @InjectMocks
    private JsoupHtmlParser parser;

    @Test
    public void parse_shouldGetDocumentFromJsoupApi() {
        String url = "url";
        when(jsoupApi.getWebPageAsDocument(anyString())).thenReturn(new Document(url));

        parser.parse(url);

        verify(jsoupApi).getWebPageAsDocument(url);
    }

    @Test
    public void parse_shouldUseDocumentExtractorToExtractTheProductElements() {
        String url = "url";
        Document document = new Document(url);
        when(jsoupApi.getWebPageAsDocument(anyString())).thenReturn(document);
        when(documentExtractor.getProductElements(any(Document.class))).thenReturn(new Elements());

        parser.parse(url);

        verify(jsoupApi).getWebPageAsDocument(url);
        verify(documentExtractor).getProductElements(document);
    }


}