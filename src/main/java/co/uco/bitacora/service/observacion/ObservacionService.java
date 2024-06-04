package co.uco.bitacora.service.observacion;


import co.uco.bitacora.domain.objetoAuxiliar.ObservacionData;
import co.uco.bitacora.domain.revision.Revision;
import co.uco.bitacora.rabbitMQ.Publicador;
import co.uco.bitacora.rabbitMQ.Suscription;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObservacionService {
    @Autowired
    private Publicador publicador;

    @Autowired
    private Suscription suscripcion1;




    @Transactional
    public String actualizarObservacion(ObservacionData observacionData) throws InterruptedException {


        try {
            Revision revision = new Revision();

            pedirRevisionAlProcesador(observacionData.getidRevision());
            Thread.sleep(1000);
            Revision revision1 = suscripcion1.getRevision();

            revision.setId(revision1.getId());
            revision.setFechaFinal(revision1.getFechaFinal());
            revision.setEquipo(revision1.getEquipo());
            revision.setObservacion(revision1.getObservacion());
            revision.setChekList(revision1.getChekList());

            revision.getObservacion().setDescripcion(observacionData.getDescripcion());
            revision.getObservacion().setMejora(observacionData.getMejora());

            System.out.println( "entro al metodo ");

            publicador.publicarColaA(revision);

            return "se realizo la mejora con exito";
        }catch (Exception e ){
            return "No se puede realizar la actualizacion " + e.getMessage();
        }


    }


    private void pedirRevisionAlProcesador(long id) {
        publicador.publicarColaC(id);
    }


}

