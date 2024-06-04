package co.uco.bitacora.domain.objetoAuxiliar;

public class ObservacionData {

    private long idRevision;
    private String mejora;
    private String descripcion;


    public long getidRevision() {
        return idRevision;
    }

    public void setidRevision(long idObservacion) {
        this.idRevision = idObservacion;
    }

    public String getMejora() {
        return mejora;
    }

    public void setMejora(String mejora) {
        this.mejora = mejora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
