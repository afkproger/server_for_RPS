package ru.technolog.sorting_algorithms_server.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import ru.technolog.sorting_algorithms_server.services.saUserService;


import java.util.Collections;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private saUserService sortUserService;
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(request ->
                {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.addAllowedOrigin("*");
                    return config;
                }))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                antMatcher("/api/v1/**")
                        ).anonymous()
                        .requestMatchers(
                                antMatcher("/api/v1/auth/**"),
                                antMatcher("/swagger-ui/**"),
                                antMatcher("/api-docs/**"),
                                antMatcher("/login"),
                                antMatcher("/register")
                        ).permitAll()
                        .anyRequest().permitAll()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(AbstractHttpConfigurer::disable)
                .userDetailsService(sortUserService)
                .build();
    }

}