package uk.co.sainsbury;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.sainsbury.service.HtmlParser;
import uk.co.sainsbury.service.Product;
import uk.co.sainsbury.service.ScrapingService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScrapingServiceTest {

    @Mock
    private HtmlParser parser;

    @InjectMocks
    private ScrapingService service;

    @Test
    public void scrape_shouldUseParserToParseUrlReturningListOfProducts() {
        Product product = new Product("Kiwi", 325, BigDecimal.TEN, "Healthy Stuff");
        when(parser.parse(anyString())).thenReturn(Collections.singletonList(product));
        List<Product> result = service.scrape("url");

        assertThat(result).containsOnly(product);
        verify(parser).parse("url");
    }
}