package uk.co.sainsbury;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
    public void scrape_shouldUseParserToParseUrl() {
        when(parser.parse(anyString())).thenReturn(null);
        String result = service.scrape("url");

        assertThat(result).isEqualTo("null");
        verify(parser).parse("url");
    }
}