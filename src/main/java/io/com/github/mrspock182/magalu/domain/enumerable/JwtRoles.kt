package io.com.github.mrspock182.magalu.domain.enumerable

import org.springframework.security.core.GrantedAuthority
import com.fasterxml.jackson.annotation.JsonValue
import io.com.github.mrspock182.magalu.domain.enumerable.JwtRoles

enum class JwtRoles(private val value: String) : GrantedAuthority {
    ROLE_USER("ROLE_USER");

    override fun getAuthority(): String {
        return value
    }

    @JsonValue
    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(text: String?): JwtRoles? {
            for (b in values()) {
                if (b.value.equals(text, ignoreCase = true)) {
                    return b
                }
            }
            return null
        }
    }
}