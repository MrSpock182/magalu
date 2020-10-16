package io.com.github.mrspock182.magalu.integration.implementation;

import io.com.github.mrspock182.magalu.dto.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "via-cep", url = "${magalu.integration.viacep}")
public interface ViaCepIntegrationWithFeign {
    @GetMapping("/{cep}/json/")
    ViaCepResponse getAddress(@PathVariable String cep);
}
