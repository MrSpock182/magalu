package io.com.github.mrspock182.magalu.api

import io.com.github.mrspock182.magalu.dto.ClientCepResponse
import io.com.github.mrspock182.magalu.service.ClientSearchCepService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/magalu/cep"])
class ClientCepApi(private val service: ClientSearchCepService) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = ["/search/{cep}"])
    fun searchCep(@PathVariable cep: String) : ClientCepResponse {
        return service.search(cep)
    }

}