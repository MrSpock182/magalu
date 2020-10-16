package io.com.github.mrspock182.magalu.dto

class ViaCepResponse(@get:JvmName("getLogradouro") val logradouro: String,
                     @get:JvmName("getBairro") val bairro: String,
                     @get:JvmName("getLocalidade") val localidade: String,
                     @get:JvmName("getUf") val uf: String)