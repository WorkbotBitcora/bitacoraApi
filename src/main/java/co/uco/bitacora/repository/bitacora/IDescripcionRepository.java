package co.uco.bitacora.repository.bitacora;

import co.uco.bitacora.domain.bitacora.descripcion.Descripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDescripcionRepository extends JpaRepository<Descripcion,Long> {
}
