package co.uco.bitacora.repository.bitacora;

import co.uco.bitacora.domain.bitacora.Bitacora;
import co.uco.bitacora.domain.bitacora.BitacoraDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBitacoraDBRepository extends JpaRepository<BitacoraDB, Long > {

}
