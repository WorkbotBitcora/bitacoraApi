package co.uco.bitacora.domain.usuario;

public class RespuetaUsuarioLogin {
    private long id ;
    private String nombre ;
    private String token;

    public String getToken() {
        return token;
    }

    public RespuetaUsuarioLogin() {
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RespuetaUsuarioLogin(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
