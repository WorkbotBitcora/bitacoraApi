package co.uco.bitacora.repository.usuario;

import co.uco.bitacora.domain.usuario.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario,Long> {
}
