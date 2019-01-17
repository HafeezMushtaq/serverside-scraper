package uk.co.sainsbury;

import com.google.gson.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.sainsbury.api.JsoupException;
import uk.co.sainsbury.service.ScrapingService;
import uk.co.sainsbury.model.ProductInformation;
import uk.co.sainsbury.usecase.ScraperUseCase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ScraperUseCaseTest {

    @Mock
    private ScrapingService scrapingService;

    @InjectMocks
    private ScraperUseCase useCase;

    @Test
    public void scrape_shouldReturnProductInformationAsJsonTree() throws JsoupException {
        ProductInformation productInformation = new ProductInformation(null, null);
        when(scrapingService.scrape(anyString())).thenReturn(productInformation);

        JsonElement result = useCase.scrape("url");

        assertThat(result).isEqualTo(new Gson().toJsonTree(productInformation));
        verify(scrapingService).scrape("url");
    }

    @Test
    public void scrape_shouldReturnJsonObjectWithErrorIfJsoupExceptionIsThrown() throws JsoupException {
        doThrow(JsoupException.class).when(scrapingService).scrape(anyString());

        JsonElement result = useCase.scrape("webpage/does-not-exist");


        assertThat(result.toString()).isEqualTo("{\"error\":\"Please check URL - Could not connect to [webpage/does-not-exist]\"}");
        verify(scrapingService).scrape("webpage/does-not-exist");
    }
}