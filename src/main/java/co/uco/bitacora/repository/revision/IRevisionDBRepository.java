package co.uco.bitacora.repository.revision;

import co.uco.bitacora.domain.revision.RevisionDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRevisionDBRepository extends JpaRepository<RevisionDB, Long> {
}
