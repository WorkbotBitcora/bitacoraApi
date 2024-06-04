package co.uco.bitacora.repository.bitacora;

import co.uco.bitacora.domain.bitacora.estado.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado,Long> {
}
