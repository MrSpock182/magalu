package io.com.github.mrspock182.magalu.service.implementation;

import io.com.github.mrspock182.magalu.dto.ClientCepResponse;
import io.com.github.mrspock182.magalu.exception.BadRequestException;
import io.com.github.mrspock182.magalu.integration.SearchCepIntegration;
import io.com.github.mrspock182.magalu.service.ClientCepValidationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientCepValidationServiceImpl implements ClientCepValidationService {

    private final SearchCepIntegration integration;

    public ClientCepValidationServiceImpl(SearchCepIntegration integration) {
        this.integration = integration;
    }

    @Override
    public ClientCepResponse validate(String clientCep) {
       String cep = Optional.ofNullable(clientCep)
                .filter(c -> c.length() == 8)
                .filter(c -> c.matches("-?\\d+(\\.\\d+)?"))
                .orElseThrow(() -> new BadRequestException("CEP inválido"));
        return integration.searchCep(cep);
    }
}
