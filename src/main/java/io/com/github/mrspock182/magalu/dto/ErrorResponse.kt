package io.com.github.mrspock182.magalu.dto

import java.util.*

data class ErrorResponse(@get:JvmName("getDate") val date: Date,
                         @get:JvmName("getPath") val path: String,
                         @get:JvmName("getStatus") val status: Int,
                         @get:JvmName("getError") val error: String,
                         @get:JvmName("getMessage") val message: String)