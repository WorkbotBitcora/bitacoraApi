package co.uco.bitacora.domain.usuario;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String nombre;
    private String apellido;

    @Column(nullable = false, unique = true)
    private String usuario;

    private String contrasena;

    @ManyToOne
    private TipoUsuario tipoUsuario;



    public Usuario(long id, String nombre, TipoUsuario idTipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.tipoUsuario = idTipoUsuario;

    }

    public Usuario(String nombre, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;

    }

    public Usuario(String nombre, String apellido, String usuario, String contrasena, long tipoUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipoUsuario= new TipoUsuario(tipoUsuario);
    }

    public Usuario(String nombre, String apellido, String usuario, String contrasena, TipoUsuario tipoUsuario) {
        setNombre(nombre);
        setApellido(apellido);
        setUsuario(usuario);
        setContrasena(contrasena);
        setTipoUsuario(tipoUsuario);
    }

    public Usuario() {

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

    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getUsuario() {return usuario;}

    public void setUsuario(String usuario) {this.usuario = usuario;}

    public String getContrasena() {return contrasena;}

    public void setContrasena(String contrasena) {this.contrasena = contrasena;}

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /// temas de seguridad

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((tipoUsuario.getDescripcion())));
    }

    @Override
    public String getPassword() {
        return this.contrasena;
    }

    @Override
    public String getUsername() {
        return this.usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
