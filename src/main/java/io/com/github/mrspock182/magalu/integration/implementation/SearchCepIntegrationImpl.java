package io.com.github.mrspock182.magalu.integration.implementation;

import io.com.github.mrspock182.magalu.adapter.Adapter;
import io.com.github.mrspock182.magalu.dto.ClientCepResponse;
import io.com.github.mrspock182.magalu.dto.ViaCepResponse;
import io.com.github.mrspock182.magalu.integration.SearchCepIntegration;
import org.springframework.stereotype.Component;

@Component
public class SearchCepIntegrationImpl implements SearchCepIntegration {

    private final ViaCepIntegrationWithFeign integration;
    private final Adapter<ClientCepResponse, ViaCepResponse> adapter;

    public SearchCepIntegrationImpl(ViaCepIntegrationWithFeign integration,
                                    Adapter<ClientCepResponse, ViaCepResponse> adapter) {
        this.integration = integration;
        this.adapter = adapter;
    }

    @Override
    public ClientCepResponse searchCep(String cep) {
        return adapter.cast(integration.getAddress(cep));
    }
}
