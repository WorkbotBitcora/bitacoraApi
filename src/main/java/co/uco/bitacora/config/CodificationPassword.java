package co.uco.bitacora.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CodificationPassword implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return String.valueOf(rawPassword.toString().hashCode());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        var password = String.valueOf(rawPassword.toString().hashCode());
        return encodedPassword.equals(password);
    }
}
