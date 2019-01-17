package uk.co.sainsbury;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.sainsbury.converter.Converter;
import uk.co.sainsbury.utility.HtmlParser;
import uk.co.sainsbury.utility.Product;
import uk.co.sainsbury.service.ScrapingService;
import uk.co.sainsbury.model.DisplayProduct;
import uk.co.sainsbury.model.ProductInformation;
import uk.co.sainsbury.usecase.Total;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScrapingServiceTest {

    @Mock
    private HtmlParser parser;

    @Mock
    private Converter<List<Product>, ProductInformation> converter;

    @InjectMocks
    private ScrapingService service;

    @Test
    public void scrape_shouldUseParserToParseUrlReturningProductInformation() {
        Product product = new Product("Kiwi", 325, BigDecimal.TEN, "Healthy Stuff");
        Total total = new Total(BigDecimal.TEN, BigDecimal.ONE);
        DisplayProduct displayProduct = new DisplayProduct("Kiwi", 325, BigDecimal.TEN, "Healthy Stuff");
        ProductInformation productInfo = new ProductInformation(Collections.singletonList(displayProduct), total);
        when(parser.parse(anyString())).thenReturn(Collections.singletonList(product));
        when(converter.convert(anyListOf(Product.class))).thenReturn(productInfo);

        ProductInformation result = service.scrape("url");

        assertThat(result).isEqualTo(productInfo);
        verify(parser).parse("url");
    }
}