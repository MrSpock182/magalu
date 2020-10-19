package io.com.github.mrspock182.magalu.domain.bean

import io.com.github.mrspock182.magalu.domain.enumerable.JwtRoles
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors

class User : UserDetails {
    private val roles = listOf(JwtRoles.ROLE_USER)
    override fun getUsername(): String {
        return "admin"
    }

    override fun getPassword(): String {
        return "password"
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun isAccountNonExpired(): Boolean {
        return false
    }

    override fun isAccountNonLocked(): Boolean {
        return false
    }

    override fun isCredentialsNonExpired(): Boolean {
        return false
    }

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return roles.stream().map { authority: JwtRoles -> SimpleGrantedAuthority(authority.name) }
                .collect(Collectors.toList())
    }
}