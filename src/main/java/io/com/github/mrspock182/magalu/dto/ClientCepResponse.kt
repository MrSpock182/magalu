package io.com.github.mrspock182.magalu.dto

data class ClientCepResponse(@get:JvmName("getStreet") val street: String,
                             @get:JvmName("getNeighborhood") val neighborhood: String,
                             @get:JvmName("getCity") val city: String,
                             @get:JvmName("getState") val state: String)