package uk.co.sainsbury;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.sainsbury.service.ScrapingService;
import uk.co.sainsbury.usecase.ProductInformation;
import uk.co.sainsbury.usecase.ScraperUseCase;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScraperUseCaseTest {

    @Mock
    private ScrapingService scrapingService;

    @Test
    public void scrape_shouldReturnProductInformation() {
        ScraperUseCase useCase = new ScraperUseCase(scrapingService);
        when(scrapingService.scrape(anyString())).thenReturn(Collections.EMPTY_LIST);

        ProductInformation result = useCase.scrape("url");

        assertThat(result).isEqualTo(new ProductInformation(null, null));
        verify(scrapingService).scrape("url");
    }
}