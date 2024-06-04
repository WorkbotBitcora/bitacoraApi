package co.uco.bitacora.service.check;

import co.uco.bitacora.domain.objetoAuxiliar.DatoChek;
import co.uco.bitacora.domain.revision.Chek;
import co.uco.bitacora.domain.revision.Revision;
import co.uco.bitacora.rabbitMQ.Publicador;
import co.uco.bitacora.rabbitMQ.Suscription;
import co.uco.bitacora.service.recomendacion.RecomendacionService;
import jakarta.transaction.Transactional;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class ChekService {

    @Autowired
    private Publicador publicador;
    @Autowired
    private Suscription suscripcion1;

    @Autowired
    private RecomendacionService servicioRecomendaciones = new RecomendacionService();



    // Método para obtener los checks de un portátil
    @Transactional
    public List<Chek> obtenerChecksPorId(long idTipoEquipo){
       try {
           List<Chek> cheks = new ArrayList<>();
           switch ((int) idTipoEquipo) {
               case 4:
                   //estos son los de mesa
                   cheks.add(new Chek(12, "Memoria RAM",4, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(12)));
                   cheks.add(new Chek(13, "Disco Duro/SSD",4, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(13)));
                   cheks.add(new Chek(14, "Tarjeta gráfica (GPU)",4, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(14)));
                   cheks.add(new Chek(15, "Ventilación y refrigeración",4, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(15)));
                   cheks.add(new Chek(16, "Monitor",4, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(16)));
                   cheks.add(new Chek(17, "Sistema Operativo",4, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(17)));
                   cheks.add(new Chek(18, "Controladores de dispositivos",4, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(18)));
                   cheks.add(new Chek(19, "Puertos USB",4, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(19)));
                   cheks.add(new Chek(20, "Pruebas de rendimiento (benchmarking)",4, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(20)));
                   cheks.add(new Chek(21, "Temperatura del sistema",4, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(21)));
                   cheks.add(new Chek(22, "Actualizaciones de software y controladores",4, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(22)));

                   break;
                   case 2:
                       // estos son los de celular
                       cheks.add(new Chek(23, "Estado exterior",2, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(23)));
                       cheks.add(new Chek(24, "Pantalla",2, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(24)));
                       cheks.add(new Chek(25, "Botones y puertos",2, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(25)));
                       cheks.add(new Chek(26, "Cámaras",2, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(26)));
                       cheks.add(new Chek(27, "Altavoces y micrófono",2, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(27)));
                       cheks.add(new Chek(28, "Sensores y funciones especiales",2, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(28)));
                       cheks.add(new Chek(29, "Condiciones de la batería",2, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(29)));
                       cheks.add(new Chek(30, "Software",2, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(30)));

                       break;
                       case 3:
                           //estos son los de portatil
                           cheks.add(new Chek(1, "Batería",3,  true, servicioRecomendaciones.listarRecomendacionesPorIDChek(1)));
                           cheks.add(new Chek(2, "Pantalla",3, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(2)));
                           cheks.add(new Chek(3, "Sistema Operativo", 3,true, servicioRecomendaciones.listarRecomendacionesPorIDChek(3)));
                           cheks.add(new Chek(4, "Controladores",3, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(4)));
                           cheks.add(new Chek(5, "Programas",3, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(5)));
                           cheks.add(new Chek(6, "Seguridad",3, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(6)));
                           cheks.add(new Chek(7, "Pruebas de rendimiento",3, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(7)));
                           cheks.add(new Chek(8, "Temperatura",3, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(8)));
                           cheks.add(new Chek(9, "Cámaras y sensores",3, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(9)));
                           cheks.add(new Chek(10, "Teclado y touchpad",3, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(10)));
                           cheks.add(new Chek(11, "Conexiones",3, true, servicioRecomendaciones.listarRecomendacionesPorIDChek(11)));

                           break;
               default:
                   //este es el nulo
                   cheks.add(new Chek(31,"No hay Cheks",1,true,servicioRecomendaciones.CargarRecomendaciones(31)));
                  break;
           }

           return cheks;

       }catch (Exception e){
           System.out.println("Error en el optener cheks");
           throw new RuntimeException(e.getMessage());
       }

    }


    //ESTE METODO FUNCIONA PERO NO ESTA BIEN IMPLEMENTADO
    @Transactional
    public String crearChekRevisadosConIdEquipoYIdRevision(long idRevision, List<DatoChek> listRespuesta) throws InterruptedException {

        Revision revision = new Revision();
        pedirRevisionAlProcesador(idRevision);
        Thread.sleep(1000);
        Revision revision1 = suscripcion1.getRevision();

        revision.setId(revision1.getId());
        revision.setFechaFinal(revision1.getFechaFinal());
        revision.setEquipo(revision1.getEquipo());
        revision.setObservacion(revision1.getObservacion());
        revision.setChekList(revision1.getChekList());

        try {
            for (int i = 0; i < revision.getChekList().size(); i++) {
                if (revision.getChekList().get(i).getId() == listRespuesta.get(i).getIdChek()){
                        revision.getChekList().get(i).setEstado(listRespuesta.get(i).getEstado());
                }
            }
            publicador.publicarColaA(revision);
            return "Se guardo con exito";

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }



    private void pedirRevisionAlProcesador(long id) {
        publicador.publicarColaC(id);
    }


}
