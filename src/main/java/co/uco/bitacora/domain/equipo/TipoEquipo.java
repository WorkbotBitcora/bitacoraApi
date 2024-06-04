package co.uco.bitacora.domain.equipo;

import jakarta.persistence.*;


public class TipoEquipo {

    private long id;

    private String nombre;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoEquipo() {
        this.id = 1;
        this.nombre="No hay Equipo Registrado";
    }

    public TipoEquipo(long id) {
            switch ((int)id){
                case 2:
                    this.id=id;
                    this.nombre = "Celular";
                    break;
                case 3:
                    this.id=id;
                    this.nombre = "Portatil";
                    break;
                case 4:
                    this.id=id;
                    this.nombre = "Mesa";
                    break;
                default:
                    this.id = 1;
                    this.nombre="No hay Equipo Registrado";
            }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
