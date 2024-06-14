package co.uco.bitacora.domain.usuario;

public class RespuestaUsuarioRegistro {
    private String status;

    public RespuestaUsuarioRegistro() {
        this.status = "Ok";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
