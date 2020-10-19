package io.com.github.mrspock182.magalu.integration.implementation;

import feign.FeignException;
import io.com.github.mrspock182.magalu.adapter.Adapter;
import io.com.github.mrspock182.magalu.domain.dto.ClientCepResponse;
import io.com.github.mrspock182.magalu.domain.dto.PostmonResponse;
import io.com.github.mrspock182.magalu.exception.NotFoundException;
import io.com.github.mrspock182.magalu.integration.SearchCepIntegration;
import org.springframework.stereotype.Component;

@Component
public class SearchCepIntegrationImpl implements SearchCepIntegration {

    private final PostmonIntegrationWithFeign integration;
    private final Adapter<ClientCepResponse, PostmonResponse> adapter;

    public SearchCepIntegrationImpl(PostmonIntegrationWithFeign integration,
                                    Adapter<ClientCepResponse, PostmonResponse> adapter) {
        this.integration = integration;
        this.adapter = adapter;
    }

    @Override
    public ClientCepResponse searchCep(String cep) {
        try {
            PostmonResponse response = integration.getAddress(cep);
            return adapter.cast(response);
        } catch (FeignException ex) {
            throw new NotFoundException(ex);
        }
    }
}
