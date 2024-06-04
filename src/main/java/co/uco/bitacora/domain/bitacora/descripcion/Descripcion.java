package co.uco.bitacora.domain.bitacora.descripcion;

import jakarta.persistence.*;

@Entity
@Table(name = "Descripciones")
public class Descripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private  String descripcion;

    public Descripcion() {
        this.id= 0 ;
        this.descripcion= "descripcion vacia" ;
    }

    public Descripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Descripcion(long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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
}
