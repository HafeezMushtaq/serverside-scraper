package uk.co.sainsbury;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.sainsbury.service.ScrapingService;
import uk.co.sainsbury.usecase.ScraperUseCase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScraperUseCaseTest {

    @Mock
    private ScrapingService scrapingService;

    @Test
    public void scrape_shouldReturnUrl() {
        ScraperUseCase useCase = new ScraperUseCase(scrapingService);
        when(scrapingService.scrape(anyString())).thenReturn("url");

        String result = useCase.scrape("url");

        assertThat(result).isEqualTo("url");
        verify(scrapingService).scrape("url");
    }
}