package io.com.github.mrspock182.magalu.service;

import io.com.github.mrspock182.magalu.TestSetup;
import io.com.github.mrspock182.magalu.domain.dto.ClientCepResponse;
import io.com.github.mrspock182.magalu.exception.BadRequestException;
import io.com.github.mrspock182.magalu.exception.NotFoundException;
import io.com.github.mrspock182.magalu.integration.SearchCepIntegration;
import io.com.github.mrspock182.magalu.service.implementation.ClientSearchCepServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClientSearchCepServiceImplTest extends TestSetup {

    @InjectMocks
    private ClientSearchCepServiceImpl service;

    @Mock
    private SearchCepIntegration integration;

    @Mock
    private CepValidatorService cepValidatorService;

    @Override
    public void init() {
    }

    private ClientCepResponse getResponse() {
        return new ClientCepResponse("Avenida Paulista", "Bela Vista", "São Paulo", "SP");
    }

    @Test
    public void searchCepSuccessTest() {
        when(integration.searchCep("01311000")).thenReturn(getResponse());
        service.search("01311000");
        verify(integration).searchCep("01311000");
        verify(cepValidatorService).validate("01311000");
    }

    @Test
    public void searchCepResponseNullTest() {
        when(integration.searchCep("01311000")).thenReturn(null);
        ClientCepResponse response = service.search("01311000");
        assertNull(response);
    }

    @Test
    public void retriesSearchingByReplacingLastDigitsWhenCepDoesNotExistTest() {
        when(integration.searchCep("01311234"))
                .thenThrow(NotFoundException.class);
        when(integration.searchCep("01311230"))
                .thenThrow(NotFoundException.class);
        when(integration.searchCep("01311200"))
                .thenThrow(NotFoundException.class);
        when(integration.searchCep("01311000"))
                .thenThrow(NotFoundException.class);
        when(integration.searchCep("01310000"))
                .thenThrow(NotFoundException.class);
        when(integration.searchCep("01300000"))
                .thenThrow(NotFoundException.class);
        when(integration.searchCep("01000000"))
                .thenReturn(getResponse());

        service.search("01311234");

        verify(integration, times(1)).searchCep("01311234");
        verify(integration, times(1)).searchCep("01311230");
        verify(integration, times(1)).searchCep("01311200");
        verify(integration, times(1)).searchCep("01311000");
        verify(integration, times(1)).searchCep("01310000");
        verify(integration, times(1)).searchCep("01300000");
        verify(integration, times(1)).searchCep("01000000");

        verify(cepValidatorService, times(1)).validate("01311234");
        verify(cepValidatorService, times(1)).validate("01311230");
        verify(cepValidatorService, times(1)).validate("01311200");
        verify(cepValidatorService, times(1)).validate("01311000");
        verify(cepValidatorService, times(1)).validate("01310000");
        verify(cepValidatorService, times(1)).validate("01300000");
        verify(cepValidatorService, times(1)).validate("01000000");
    }

    @Test(expected = BadRequestException.class)
    public void retriesSearchingByReplacingLastDigitsWhenCepDoesNotExistFailsTest() {
        when(integration.searchCep("01311234"))
                .thenThrow(NotFoundException.class);
        when(integration.searchCep("01311230"))
                .thenThrow(NotFoundException.class);
        when(integration.searchCep("01311200"))
                .thenThrow(NotFoundException.class);
        when(integration.searchCep("01311000"))
                .thenThrow(NotFoundException.class);
        when(integration.searchCep("01310000"))
                .thenThrow(NotFoundException.class);
        when(integration.searchCep("01300000"))
                .thenThrow(NotFoundException.class);
        when(integration.searchCep("01000000"))
                .thenThrow(NotFoundException.class);

        doNothing().when(cepValidatorService).validate("01311234");
        doNothing().when(cepValidatorService).validate("01311230");
        doNothing().when(cepValidatorService).validate("01311200");
        doNothing().when(cepValidatorService).validate("01311000");
        doNothing().when(cepValidatorService).validate("01310000");
        doNothing().when(cepValidatorService).validate("01300000");
        doNothing().when(cepValidatorService).validate("01000000");
        doThrow(BadRequestException.class).when(cepValidatorService).validate("00000000");

        service.search("01311234");

        verify(integration, times(1)).searchCep("01311234");
        verify(integration, times(1)).searchCep("01311230");
        verify(integration, times(1)).searchCep("01311200");
        verify(integration, times(1)).searchCep("01311000");
        verify(integration, times(1)).searchCep("01310000");
        verify(integration, times(1)).searchCep("01300000");
        verify(integration, times(1)).searchCep("01000000");

        verify(cepValidatorService, times(1)).validate("01311234");
        verify(cepValidatorService, times(1)).validate("01311230");
        verify(cepValidatorService, times(1)).validate("01311200");
        verify(cepValidatorService, times(1)).validate("01311000");
        verify(cepValidatorService, times(1)).validate("01310000");
        verify(cepValidatorService, times(1)).validate("01300000");
        verify(cepValidatorService, times(1)).validate("01000000");
        verify(cepValidatorService, times(1)).validate("00000000");
    }


}
