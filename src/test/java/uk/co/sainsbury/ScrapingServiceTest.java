package uk.co.sainsbury;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScrapingServiceTest {

    @Test
    public void scrape_shouldReturnUrl() {
        ScrapingService service = new ScrapingService();
        String result = service.scrape("url");

        assertThat(result).isEqualTo("url");
    }
}