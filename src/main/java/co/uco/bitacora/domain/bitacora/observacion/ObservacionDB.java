package co.uco.bitacora.domain.bitacora.observacion;

import jakarta.persistence.*;

@Entity
@Table(name = "Observacion")
public class ObservacionDB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String observacion;

    public ObservacionDB() {
        this.observacion = "vacio";
    }

    public ObservacionDB(long id, String observacion) {
        this.id = id;
        this.observacion = observacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
