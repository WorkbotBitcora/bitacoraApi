package co.uco.bitacora.service.revision;

import co.uco.bitacora.domain.bitacora.observacion.Observacion;
import co.uco.bitacora.domain.bitacora.observacion.ObservacionDB;
import co.uco.bitacora.domain.equipo.Equipo;
import co.uco.bitacora.domain.equipo.EquipoDB;
import co.uco.bitacora.domain.revision.Revision;
import co.uco.bitacora.domain.revision.RevisionDB;
import co.uco.bitacora.rabbitMQ.Publicador;
import co.uco.bitacora.repository.observacioen.IObservacionesRepository;
import co.uco.bitacora.repository.revision.IEquipoDBRepository;
import co.uco.bitacora.repository.revision.IRevisionDBRepository;
import co.uco.bitacora.service.check.ChekService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RevisionService {

    @Autowired
    private Publicador publicador;

    @Autowired
    private ChekService chekService;

    @Autowired
    private IObservacionesRepository iObservacionesRepository;

    @Autowired
    private IRevisionDBRepository iRevisionDBRepository;
    @Autowired
    private IEquipoDBRepository iEquipoDBRepository;

    @Transactional
    public String revisionNuevaconIdTipoequipo(long id, long tipoequipo, String marca) {

        try {
            Equipo equipo = new Equipo(tipoequipo);
            iRevisionDBRepository.findById(id).ifPresent(data -> {
                equipo.setId(data.getEquipoDB().getId());
            });
            equipo.setMarca(marca);
            System.out.println("idTipo equipo  " + equipo.getTipoEquipo().getId());

            Observacion observacion = new Observacion();

            System.out.println("idTipo equipo  " + equipo.getTipoEquipo().getId());

            Revision revision = new Revision(id, observacion, equipo, chekService.obtenerChecksPorId(equipo.getTipoEquipo().getId()));
            System.out.println("va a publicar cola a");

            this.pintaRevision(revision);

            publicador.publicarColaA(revision);

            return "Se relizo con exito el cambio";
        } catch (Exception e) {
            return "Ocurrio un error al Crear una revision nueva o nula " + e.getMessage();

        }
    }


    @Transactional
    public RevisionDB revisionNuevaNula() {

        try {
            EquipoDB equipoDB = new EquipoDB();
            iEquipoDBRepository.save(equipoDB);
            RevisionDB revisionDB = new RevisionDB(equipoDB);
            iRevisionDBRepository.save(revisionDB);


            ObservacionDB observacionDB = new ObservacionDB();
            iObservacionesRepository.save( observacionDB);
            Observacion observacion = new Observacion(observacionDB.getId());

            Equipo equipo = new Equipo();
            equipo.setId(equipoDB.getId());

            System.out.println("idTipo equipo  " + equipo.getTipoEquipo().getId());

            Revision revision = new Revision(observacion, equipo, chekService.obtenerChecksPorId(equipo.getTipoEquipo().getId()));
            revision.setId(revisionDB.getId());
            System.out.println("va a publicar cola a");

            this.pintaRevision(revision);


            publicador.publicarColaA(revision);


            return revisionDB;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocurrio un error al Crear una revision nueva o nula ");
            return new RevisionDB();

        }
    }


    private void pintaRevision(Revision revision) {
        System.out.println("id :" + revision.getId());

        System.out.println("idObs :" + revision.getObservacion().getId());
        System.out.println("descObs :" + revision.getObservacion().getDescripcion());
        System.out.println("mejObs :" + revision.getObservacion().getMejora());

        System.out.println("idEQ :" + revision.getEquipo().getId());
        System.out.println("MARCAEQ :" + revision.getEquipo().getMarca());

    }

}
