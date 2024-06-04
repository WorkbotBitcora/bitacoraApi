package co.uco.bitacora.domain.bitacora;

import co.uco.bitacora.domain.bitacora.descripcion.Descripcion;
import co.uco.bitacora.domain.bitacora.estado.Estado;
import co.uco.bitacora.domain.revision.Revision;
import co.uco.bitacora.domain.usuario.Usuario;
import jakarta.persistence.*;


import java.util.Date;

public class Bitacora {

    private  long id;

    private Usuario usuario;

    private Date fechaEntrada;


    private Descripcion descripcion;


    private Revision revision;


    private Estado estado;


    public Bitacora() {
    }


    public Bitacora(Usuario usuario, Descripcion descripcion , co.uco.bitacora.domain.revision.Revision revision , Estado estado ) {
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.revision =revision;
        this.estado =estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuarioID) {
        this.usuario = usuarioID;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Descripcion getDescription() {
        return descripcion;
    }

    public void setDescripcion(Descripcion descriptionID) {
        this.descripcion = descriptionID;
    }

    public co.uco.bitacora.domain.revision.Revision getRevision() {
        return revision;
    }

    public void setRevision(co.uco.bitacora.domain.revision.Revision revisionID) {
        this.revision = revisionID;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }



}
