package co.uco.bitacora.domain.bitacora.estado;

import jakarta.persistence.*;

@Entity
@Table(name = "Estados")
public class Estado {

    @Id
    private long id ;
    private String nombre;

    public Estado() {
        this.id=1;
        this.nombre="incompleto";
    }

    public Estado(long id) {
        switch ((int)id){
            case 1:
                this.id=1;
                this.nombre = "Incompleto";
                break;
            case 2:
                this.id=2;
                this.nombre = "En Revision";
                break;
            case 3:
                this.id=3;
                this.nombre = "Completo";
                break;
            default:
                this.id = 4;
                this.nombre="Estado No Registrado";
        }
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
}
