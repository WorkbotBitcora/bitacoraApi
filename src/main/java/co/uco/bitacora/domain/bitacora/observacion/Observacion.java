package co.uco.bitacora.domain.bitacora.observacion;

import jakarta.persistence.*;


public class Observacion {

    private long id;

    private String descripcion;

    // hacer revision par

    private String mejora;

    public Observacion() {
        this.id= 1;
        this.descripcion = "vacio";
        this.mejora="vacio";
    }

    public Observacion(long id) {
        this.id= id;
        this.descripcion = "vacio";
        this.mejora="vacio";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMejora() {
        return mejora;
    }

    public void setMejora(String mejora) {
        this.mejora = mejora;
    }
}
