package co.uco.bitacora.domain.equipo;

public class RespuestaEquipoCreado {
    private String status;
    public RespuestaEquipoCreado() {
        this.status = "Ok";
    }

    public RespuestaEquipoCreado(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
