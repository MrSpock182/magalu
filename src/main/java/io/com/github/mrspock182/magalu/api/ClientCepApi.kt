package io.com.github.mrspock182.magalu.api

import io.com.github.mrspock182.magalu.dto.ClientCepResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping(value = ["/magalu/cep"])
class ClientCepApi {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = ["/search/{cep}"])
    fun searchCep(@PathVariable cep: String) : Mono<ClientCepResponse> {
        return Mono.empty()
    }

}