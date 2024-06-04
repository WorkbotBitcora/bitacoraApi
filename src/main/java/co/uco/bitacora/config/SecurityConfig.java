package co.uco.bitacora.config;

import co.uco.bitacora.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity)throws Exception
    {
        httpSecurity.cors(AbstractHttpConfigurer::disable);
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        return httpSecurity.authorizeHttpRequests(dato ->
            dato
                    .requestMatchers("/procesador/bitacora/v1/bitacora/usuario/").hasAuthority("Cliente")
                    .requestMatchers("/procesador/bitacora/v1/bitacora/agenda").hasAuthority("Cliente")
                    .requestMatchers("/procesador/bitacora/v1/bitacora/equipo/").hasAuthority("Tecnico")
                    .requestMatchers("/procesador/bitacora/v1/bitacora/agendalista").hasAuthority("Tecnico")
                    .requestMatchers("/procesador/bitacora/v1/chek/cheks/").hasAuthority("Tecnico")
                    .requestMatchers("/procesador/bitacora/v1/chek/chekfinal/").hasAuthority("Tecnico")
                    .requestMatchers("/procesador/bitacora/v1/chek/rec/").hasAuthority("Tecnico")
                    .requestMatchers("/procesador/bitacora/v1/observacion/observacion").hasAuthority("Tecnico")
                    .requestMatchers("/procesador/bitacora/v1/usuario/**").hasAuthority("Tecnico")
                    .anyRequest().permitAll()
        )
                .sessionManagement(sessionManager->
                        sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }



}
