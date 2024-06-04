package co.uco.bitacora.domain.revision;

import co.uco.bitacora.domain.bitacora.observacion.Observacion;
import co.uco.bitacora.domain.equipo.Equipo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Revision {


    private long id;

    private Date fechaFinal;

    private Observacion observacion;

    private Equipo equipo;

    private List<Chek> chekList = new ArrayList<>();

    @PrePersist
    protected void onCreate(){
        fechaFinal = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        fechaFinal = new Date();
    }



    public Revision() {
        this.id = 10;
        this.fechaFinal = new Date();
    }

    public Revision(Observacion observacion, Equipo equipo , List<Chek> chekList) {
        this.observacion = observacion;
        this.equipo = equipo;
        this.chekList = chekList;
    }

    public Revision(long id, Observacion observacion, Equipo equipo , List<Chek> chekList) {
        this.id = id;
        this.observacion = observacion;
        this.equipo = equipo;
        this.chekList = chekList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Observacion getObservacion() {
        return observacion;
    }

    public void setObservacion(Observacion observacion) {
        this.observacion = observacion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Chek> getChekList() {
        return chekList;
    }

    public void setChekList(List<Chek> chekList) {
        this.chekList = chekList;
    }
}
