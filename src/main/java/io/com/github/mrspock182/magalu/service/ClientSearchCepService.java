package io.com.github.mrspock182.magalu.service;

import io.com.github.mrspock182.magalu.dto.ClientCepResponse;

public interface ClientCepValidationService {
    ClientCepResponse validate(String cep);
}
