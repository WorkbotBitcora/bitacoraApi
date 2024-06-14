package co.uco.bitacora.repository.bitacora;

import co.uco.bitacora.domain.bitacora.Bitacora;
import co.uco.bitacora.domain.bitacora.BitacoraDB;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBitacoraDBRepository extends JpaRepository<BitacoraDB, Long > {

    @Transactional
    @Query(value = "update BitacoraDB b set b.estado.id = :estado  where b.revision.id = :ids  ")
    void cambiarEStadoBitacora(@Param("ids") long ids , @Param("estado") long estado  );


}
