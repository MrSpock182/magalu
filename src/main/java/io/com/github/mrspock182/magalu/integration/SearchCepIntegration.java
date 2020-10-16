package io.com.github.mrspock182.magalu.integration;

import io.com.github.mrspock182.magalu.dto.ClientCepResponse;

public interface SearchCepIntegration {
    ClientCepResponse searchCep(String cep);
}
