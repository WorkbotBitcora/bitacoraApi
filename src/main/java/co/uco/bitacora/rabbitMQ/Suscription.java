package co.uco.bitacora.rabbitMQ;

import co.uco.bitacora.domain.bitacora.observacion.Observacion;
import co.uco.bitacora.domain.equipo.Equipo;
import co.uco.bitacora.domain.revision.Revision;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class Suscription {

    private Revision revision = new Revision();

    @RabbitListener(queues = "queue.B")
    private void recivirDeA(Revision revisionB) {
        System.out.println("resive de la cola B " );

        System.out.println("AQUI ENTRA CUANDO LEE ALGO EN LA LISTA ");

        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Lo que recibe id " + revisionB.getId());
        System.out.println("Lo que recibe marca del equipo " + revisionB.getEquipo().getMarca());
        System.out.println("Lo que recibe mejora de la revision" + revisionB.getObservacion().getMejora());
        System.out.println("Lo que recibe" + revisionB.getFechaFinal());
        System.out.println("Lo que recibe id  del equipo " + revisionB.getEquipo().getId());


        Equipo equipo = new Equipo();
        equipo.setId(revisionB.getEquipo().getId());
        equipo.setTipoEquipo(revisionB.getEquipo().getTipoEquipo());
        equipo.setMarca(revisionB.getEquipo().getMarca());

        Observacion observacion = new Observacion();
        observacion.setId(revisionB.getObservacion().getId());
        observacion.setDescripcion(revisionB.getObservacion().getDescripcion());
        observacion.setMejora(revisionB.getObservacion().getMejora());


        revision.setId(revisionB.getId());
        revision.setEquipo(equipo);
        revision.setObservacion(observacion);
        System.out.println("-------------------------------------------------------------------------------------aqui vamos a pasar los cheks que llegan tal cual como vienen de rabbit --------------------------------------------------------------------------------");
        revision.setChekList(revisionB.getChekList());
        revision.setFechaFinal(revisionB.getFechaFinal());

        //return revision;
    }

    public Revision getRevision() {
        return revision;
    }

}
