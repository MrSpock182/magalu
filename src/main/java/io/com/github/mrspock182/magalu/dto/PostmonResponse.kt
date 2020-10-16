package io.com.github.mrspock182.magalu.dto

class PostmonResponse(@get:JvmName("getBairro") val bairro: String,
                      @get:JvmName("getCidade") val cidade: String,
                      @get:JvmName("getLogradouro") val logradouro: String,
                      @get:JvmName("getEstado") val estado: String,
)