package io.com.github.mrspock182.magalu.service;

import io.com.github.mrspock182.magalu.dto.ClientCepResponse;

public interface ClientSearchCepService {
    ClientCepResponse search(String clientCep);
}
