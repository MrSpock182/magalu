package io.com.github.mrspock182.magalu.configuration;

import io.com.github.mrspock182.magalu.domain.bean.AuthorizationApp;
import io.com.github.mrspock182.magalu.domain.bean.User;
import io.com.github.mrspock182.magalu.exception.Unauthorized;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class AuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationValidationWithJwt authenticationValidation;

    public AuthenticationFilter(AuthenticationValidationWithJwt authenticationValidation) {
        this.authenticationValidation = authenticationValidation;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        AuthorizationApp authorizationApp = null;
        final String requestTokenHeader = request.getHeader("Authorization");
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            try {
                authorizationApp = new AuthorizationApp(requestTokenHeader.substring(7),
                        authenticationValidation.getUsernameFromToken(requestTokenHeader.substring(7)));
            } catch (IllegalArgumentException e) {
                throw new Unauthorized("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                throw new Unauthorized("JWT Token has expired");
            }
        }

        if (authorizationApp != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = new User();
            if (Boolean.TRUE.equals(authenticationValidation.validateToken(authorizationApp.getToken()))) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        chain.doFilter(request, response);
    }

}
