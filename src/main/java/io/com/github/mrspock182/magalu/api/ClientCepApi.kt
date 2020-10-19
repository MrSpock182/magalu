package io.com.github.mrspock182.magalu.api

import org.springframework.http.HttpStatus.OK

import io.com.github.mrspock182.magalu.dto.ClientCepResponse
import io.com.github.mrspock182.magalu.dto.ErrorResponse
import io.com.github.mrspock182.magalu.service.ClientSearchCepService
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/magalu/cep"])
class ClientCepApi(private val service: ClientSearchCepService) {

    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Ok", response = ClientCepResponse::class),
        ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse::class),
        ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse::class),
        ApiResponse(code = 403, message = "Forbidden", response = ErrorResponse::class),
        ApiResponse(code = 404, message = "Not Found", response = ErrorResponse::class),
        ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponse::class)
    ])
    @ResponseStatus(OK)
    @GetMapping(value = ["/search/{cep}"])
    fun searchCep(@PathVariable cep: String) : ClientCepResponse {
        return service.search(cep)
    }

}