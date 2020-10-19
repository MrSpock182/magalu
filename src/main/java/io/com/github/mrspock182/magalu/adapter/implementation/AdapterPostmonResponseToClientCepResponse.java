package io.com.github.mrspock182.magalu.adapter.implementation;

import io.com.github.mrspock182.magalu.adapter.Adapter;
import io.com.github.mrspock182.magalu.domain.dto.ClientCepResponse;
import io.com.github.mrspock182.magalu.domain.dto.PostmonResponse;
import org.springframework.stereotype.Component;

@Component
public class AdapterPostmonResponseToClientCepResponse implements Adapter<ClientCepResponse, PostmonResponse> {

    @Override
    public ClientCepResponse cast(PostmonResponse response) {
        return new ClientCepResponse(response.getLogradouro(), response.getBairro(),
                response.getCidade(), response.getEstado());
    }
}
