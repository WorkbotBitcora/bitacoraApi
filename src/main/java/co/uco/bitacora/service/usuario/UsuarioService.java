package co.uco.bitacora.service.usuario;
import co.uco.bitacora.domain.usuario.TipoUsuario;
import co.uco.bitacora.domain.usuario.Usuario;

import co.uco.bitacora.domain.objetoAuxiliar.EditableUsuario;
import co.uco.bitacora.repository.usuario.IUsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;
    private TipoUsuario tipoUsuarioAux = new TipoUsuario();

    public void editarUsuario(EditableUsuario dato) {

        Usuario equ = new Usuario();
        equ.setNombre(dato.getNombre());
        equ.setApellido(dato.getApellido());
        equ.setContrasena(dato.getContrasena());
        tipoUsuarioAux = new TipoUsuario(dato.getIdTipoUsuario());
        equ.setTipoUsuario(tipoUsuarioAux);
        iUsuarioRepository.save(equ);
    }

    @Transactional
    public List<Usuario> mostrarPorUsuario(long id) {
        List<Usuario> bitacorasPorUsuario = new ArrayList<>();
        for (int i = 0; i < iUsuarioRepository.findAll().size(); i++) {
            iUsuarioRepository.findById((long) i).ifPresent(dato -> {
                if (dato.getId() == id) {
                    bitacorasPorUsuario.add(dato);
                }
            });
        }
        return bitacorasPorUsuario;
    }
    @Transactional
    public List<Usuario> mostrarUsuario() {
        return iUsuarioRepository.findAll();
    }

}