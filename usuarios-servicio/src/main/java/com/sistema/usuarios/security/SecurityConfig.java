package com.sistema.usuarios.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/auth/**").permitAll() // Permitir acceso público a la
                                                                                         // autenticación
                                                .anyRequest().authenticated()) // Requiere autenticación para el resto
                                                                               // de endpoints
                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Deshabilitar
                                                                                                         // sesiones
                                .addFilter(new JwtAuthenticationFilter()); // Agregar el filtro JWT

                return http.build();
        }
}
