package io.com.github.mrspock182.magalu.service.implementation;

import io.com.github.mrspock182.magalu.exception.BadRequestException;
import io.com.github.mrspock182.magalu.service.CepValidatorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CepValidatorServiceImpl implements CepValidatorService {

    @Override
    public void validate(String clientCep) {
        if(Optional.ofNullable(clientCep)
                .filter(c -> c.length() == 8)
                .filter(c -> !c.equals("00000000"))
                .filter(c -> c.matches("-?\\d+(\\.\\d+)?"))
                .isEmpty()) {
            throw new BadRequestException("CEP inválido");
        }
    }
}
