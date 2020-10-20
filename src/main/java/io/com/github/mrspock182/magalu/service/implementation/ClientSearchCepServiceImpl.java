package io.com.github.mrspock182.magalu.service.implementation;

import io.com.github.mrspock182.magalu.domain.dto.ClientCepResponse;
import io.com.github.mrspock182.magalu.exception.NotFoundException;
import io.com.github.mrspock182.magalu.integration.SearchCepIntegration;
import io.com.github.mrspock182.magalu.service.CepValidatorService;
import io.com.github.mrspock182.magalu.service.ClientSearchCepService;
import org.springframework.stereotype.Service;

@Service
public class ClientSearchCepServiceImpl implements ClientSearchCepService {

    private final SearchCepIntegration integration;
    private final CepValidatorService cepValidatorService;

    public ClientSearchCepServiceImpl(SearchCepIntegration integration, CepValidatorService cepValidatorService) {
        this.integration = integration;
        this.cepValidatorService = cepValidatorService;
    }

    @Override
    public ClientCepResponse search(String cep) {
        int count = cep.length() - 1;
        ClientCepResponse response = null;

        while(count >= 0 && response == null) {
            try {
                cepValidatorService.validate(cep);
                response = integration.searchCep(cep);
                count--;
            } catch (NotFoundException ex) {
                cep = replace(cep, count);
                count--;
            }
        }

        return response;
    }


    private String replace(String cep, Integer position) {
        StringBuilder replace = new StringBuilder(cep);
        replace.setCharAt(position, '0');
        return replace.toString();
    }
}
