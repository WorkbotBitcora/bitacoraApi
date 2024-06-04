package co.uco.bitacora.repository.observacioen;

import co.uco.bitacora.domain.bitacora.observacion.ObservacionDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IObservacionesRepository extends JpaRepository<ObservacionDB, Long> {
}
