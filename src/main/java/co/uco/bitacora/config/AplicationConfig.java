package co.uco.bitacora.config;

import co.uco.bitacora.repository.usuario.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AplicationConfig {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider (){

        DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(optenerUsuario());
        authenticationProvider.setPasswordEncoder(optenerPassword());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder optenerPassword() {
        return new CodificationPassword();
    }
    @Bean
    public UserDetailsService optenerUsuario() {

        return username -> iUsuarioRepository.traerUsuarioPorNombreUsuario(username).orElseThrow(()-> new UsernameNotFoundException("No se encontro el usuario"));
    }

    

}
