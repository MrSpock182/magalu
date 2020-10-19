package io.com.github.mrspock182.magalu.integration;

import io.com.github.mrspock182.magalu.domain.dto.ClientCepResponse;

public interface SearchCepIntegration {
    ClientCepResponse searchCep(String cep);
}
