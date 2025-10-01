package com.citricultura.citricultura.security

import com.citricultura.citricultura.repository.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.http.HttpMethod

@Configuration
class SecurityConfiguration {

    @Bean
    fun securityFilterChain(http: HttpSecurity,securityFilter: SecurityFilter): SecurityFilterChain {
        http.csrf { it.disable() }
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter::class.java)
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers(
                        "/api/auth/**",
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/public"
                    ).permitAll()
//                    .anyRequest().authenticated()
                    .anyRequest().permitAll()
            }
            .cors { corsConfig -> corsConfig.configurationSource(corsConfigurationSource()) }

        return http.build()
    }

//    @Bean
//    fun userDetailsService(userRepository: UserRepository): UserDetailsService = UserDetailsService { username ->
//        val user = userRepository.findByEmail(username)
//            ?: throw UsernameNotFoundException("Usuário não encontrado: $username")
//
//        val authorities = listOf(SimpleGrantedAuthority("ROLE_${user.role.name}"))
//
//        User(user.email, user.password, authorities)
//    }


    @Bean
    fun UserDetailsService(passwordEncoder: PasswordEncoder): UserDetailsService {

        val user: UserDetails =
            User.builder()
                .username("user")
                .password(passwordEncoder.encode("senha123"))
                .roles("USER")
                .build()

        val admin: UserDetails =
            User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("USER", "ADMIN")
                .build()

        return InMemoryUserDetailsManager(user, admin)
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfiguration = CorsConfiguration()
        // Use explicit origins or origin patterns when allowCredentials = true
        corsConfiguration.allowedOriginPatterns = listOf(
            "http://localhost:*",
            "http://127.0.0.1:*",
            "http://[::1]:*"
        )
        corsConfiguration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
        corsConfiguration.allowedHeaders = listOf("*")
        corsConfiguration.allowCredentials = true

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", corsConfiguration)
        return source
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager? {
        return authenticationConfiguration.getAuthenticationManager()
    }

}