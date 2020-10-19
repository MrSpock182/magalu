package io.com.github.mrspock182.magalu.domain.bean

data class AuthorizationApp(@get:JvmName("getToken") val token: String,
                            @get:JvmName("getUsername") val username: String)