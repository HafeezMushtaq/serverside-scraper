package uk.co.sainsbury;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ScraperUseCaseTest {

    @Test
    public void scrape_shouldReturnUrl() {
        ScraperUseCase useCase = new ScraperUseCase();
        String result = useCase.scrape("url");

        assertThat(result).isEqualTo("url");
    }
}