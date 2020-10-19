package io.com.github.mrspock182.magalu.configuration;

import io.com.github.mrspock182.magalu.domain.bean.Authorization;
import io.com.github.mrspock182.magalu.domain.bean.User;
import io.com.github.mrspock182.magalu.exception.Unauthorized;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class AuthenticationManager extends OncePerRequestFilter {

    private final AuthenticationValidationWithJwt auth;

    public AuthenticationManager(AuthenticationValidationWithJwt auth) {
        this.auth = auth;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        validateToken(getAuthorization(request), request);
        chain.doFilter(request, response);
    }

    private Authorization getAuthorization(HttpServletRequest request) {
        try {
            final String requestTokenHeader = request.getHeader("Authorization");
            if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
                return new Authorization(requestTokenHeader.substring(7),
                        auth.getUsernameFromToken(requestTokenHeader.substring(7)));
            }
            throw new Unauthorized("Header without Authorization");
        } catch (IllegalArgumentException e) {
            throw new Unauthorized("Unable to get JWT Token");
        } catch (ExpiredJwtException e) {
            throw new Unauthorized("JWT Token has expired");
        } catch (Exception e) {
            throw new Unauthorized("Failed to validate JWT Token");
        }
    }

    private void validateToken(Authorization authorization, HttpServletRequest request) {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = new User();
            if (Boolean.TRUE.equals(auth.validateToken(authorization.getToken()))) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
    }

}
