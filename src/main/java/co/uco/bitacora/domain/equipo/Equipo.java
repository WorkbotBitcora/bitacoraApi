package co.uco.bitacora.domain.equipo;

import jakarta.persistence.*;


public class Equipo {

    private long id;

    private TipoEquipo tipoEquipo;

    private String marca;

    public Equipo() {
        this.marca="No Hay Marca";
        this.tipoEquipo = new TipoEquipo();
    }
    public Equipo(long idTipoEquipo) {
        this.tipoEquipo = new TipoEquipo(idTipoEquipo);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(TipoEquipo tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }
}
