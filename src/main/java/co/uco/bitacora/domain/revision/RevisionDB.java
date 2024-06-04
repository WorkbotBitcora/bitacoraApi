package co.uco.bitacora.domain.revision;

import co.uco.bitacora.domain.bitacora.observacion.Observacion;
import co.uco.bitacora.domain.equipo.Equipo;
import co.uco.bitacora.domain.equipo.EquipoDB;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name = "Revision")
public class RevisionDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private EquipoDB equipoDB ;


    public RevisionDB() {
        this.equipoDB = new EquipoDB();
        this.id = 0;
    }

    public RevisionDB(EquipoDB equipoDB) {
        this.equipoDB = equipoDB;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EquipoDB getEquipoDB() {
        return equipoDB;
    }

    public void setEquipoDB(EquipoDB equipoDB) {
        this.equipoDB = equipoDB;
    }
}
