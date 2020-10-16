package io.com.github.mrspock182.magalu.integration.implementation;

import io.com.github.mrspock182.magalu.dto.PostmonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "via-cep", url = "${magalu.integration.postmon}")
public interface PostmonIntegrationWithFeign {
    @GetMapping("/v1/cep/{cep}")
    PostmonResponse getAddress(@PathVariable String cep);
}
