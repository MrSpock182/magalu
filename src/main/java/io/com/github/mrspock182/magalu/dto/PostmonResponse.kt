package io.com.github.mrspock182.magalu.dto

class ViaCepResponse(@get:JvmName("getCep") val cep: String,
                     @get:JvmName("getLogradouro") val logradouro: String,
                     @get:JvmName("getComplemento") val complemento: String,
                     @get:JvmName("getBairro") val bairro: String,
                     @get:JvmName("getLocalidade") val localidade: String,
                     @get:JvmName("getUf") val uf: String,
                     @get:JvmName("getIbge") val ibge: String,
                     @get:JvmName("getGia") val gia: String,
                     @get:JvmName("getDdd") val ddd: String,
                     @get:JvmName("getSiafi") val siafi: String,
                     @get:JvmName("getErro") val erro: Boolean
)