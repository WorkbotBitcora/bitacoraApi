package co.uco.bitacora.domain.bitacora;

public class RespuestaAgendaCreada {
    private String status;

    public RespuestaAgendaCreada() {
        this.status = "Ok";
    }

    public RespuestaAgendaCreada(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
