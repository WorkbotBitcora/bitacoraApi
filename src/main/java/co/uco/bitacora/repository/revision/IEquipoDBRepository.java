package co.uco.bitacora.repository.revision;

import co.uco.bitacora.domain.equipo.EquipoDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipoDBRepository extends JpaRepository<EquipoDB, Long> {
}
