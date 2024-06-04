package co.uco.bitacora.domain.jwt;

import co.uco.bitacora.domain.usuario.RespuetaUsuarioLogin;

public class JwtResponse {
    private  String token;



    public String getToken() {
        return token;
    }
    public JwtResponse(String token ) {
        this.token = token;
    }
}
