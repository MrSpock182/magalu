package io.com.github.mrspock182.magalu.adapter.implementation;

import io.com.github.mrspock182.magalu.adapter.Adapter;
import io.com.github.mrspock182.magalu.dto.ClientCepResponse;
import io.com.github.mrspock182.magalu.dto.ViaCepResponse;
import org.springframework.stereotype.Component;

@Component
public class AdapterViaCepResponseToClientCepResponse implements Adapter<ClientCepResponse, ViaCepResponse> {

    @Override
    public ClientCepResponse cast(ViaCepResponse response) {
        return new ClientCepResponse(response.getLogradouro(), response.getBairro(),
                response.getLocalidade(), response.getUf());
    }
}
