package co.uco.bitacora.domain.bitacora;

import co.uco.bitacora.domain.bitacora.descripcion.Descripcion;
import co.uco.bitacora.domain.bitacora.estado.Estado;
import co.uco.bitacora.domain.revision.RevisionDB;
import co.uco.bitacora.domain.usuario.Usuario;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Bitacoras")
public class BitacoraDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    @ManyToOne
    private Usuario usuario;

    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;

    @ManyToOne
    private Descripcion descripcion;

    @ManyToOne
    private RevisionDB revision;

    @ManyToOne
    private Estado estado;

    @PrePersist
    protected void onCreate(){
        fechaEntrada = new Date();
    }

    public BitacoraDB() {
    }


    public BitacoraDB(Usuario usuario, Descripcion descripcion , RevisionDB revision , Estado estado ) {
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.revision = revision;
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

    public RevisionDB getRevision() {
        return revision;
    }

    public void setRevision(RevisionDB revisionID) {
        this.revision = revisionID;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }



}
