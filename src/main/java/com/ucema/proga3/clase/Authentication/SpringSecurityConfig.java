package com.ucema.proga3.clase.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //Deshabilita la protección CSRF (Cross-Site Request Forgery)
                .csrf().disable()
                .cors().and()
                //Establece la creación de sesiones en STATELESS, la aplicación no cree sesiones de usuario
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //Inicia la configuración de las reglas de autorización de las solicitudes HTTP
                .authorizeHttpRequests()
                // Establece que cualquiera puede ejecutar los endpoints de esa ruta
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/usuario").permitAll()
                .requestMatchers("/api/usuario/create").permitAll()
//                .requestMatchers("/api/bank/**").permitAll()
                .requestMatchers("/api/aviso/**").permitAll()
                .requestMatchers("/api/reserva/**").permitAll()
                // Establece que solo usuarios administradores pueden ejecutar los endpoints de esa ruta
                .requestMatchers("/api/admin/**").hasAuthority("ADMIN")
                // Para cualquier otra request, debe haber un usuario autenticado.
                .anyRequest().authenticated();
        // Agregamos un filtro personalizado
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}