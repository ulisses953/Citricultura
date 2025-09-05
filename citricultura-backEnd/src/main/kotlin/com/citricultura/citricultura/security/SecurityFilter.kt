package com.citricultura.citricultura.security

import com.citricultura.citricultura.service.JwtService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource

@Component
class SecurityFilter(private val jwtService: JwtService,
                     private val userDetailsService: UserDetailsService
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authHeader = request.getHeader("Authorization")

        if (authHeader.isNullOrBlank() || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response)
            return
        }

        val token = authHeader.substringAfter("Bearer ").trim()

        try {
            val username = jwtService.validateToken(token)

            if (username.isBlank()) {
                filterChain.doFilter(request, response)
                return
            }

            val context = SecurityContextHolder.getContext()
            if (context.authentication == null) {
                val userDetails = userDetailsService.loadUserByUsername(username)
                val authentication = UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.authorities
                )
                authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                context.authentication = authentication
            }

            filterChain.doFilter(request, response)
        } catch (_: Exception) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido ou expirado")
        }
    }
}