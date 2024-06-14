package co.uco.bitacora.service.bitacora;

import co.uco.bitacora.domain.bitacora.*;
import co.uco.bitacora.domain.bitacora.descripcion.Descripcion;
import co.uco.bitacora.domain.bitacora.estado.Estado;
import co.uco.bitacora.domain.equipo.RespuestaEquipoCreado;
import co.uco.bitacora.domain.equipo.TipoEquipo;
import co.uco.bitacora.domain.objetoAuxiliar.DatosEquipo;
import co.uco.bitacora.domain.recomendacion.Recomendacion;
import co.uco.bitacora.domain.revision.Revision;
import co.uco.bitacora.domain.usuario.TipoUsuario;
import co.uco.bitacora.domain.usuario.Usuario;
import co.uco.bitacora.domain.usuario.userDescription;
import co.uco.bitacora.rabbitMQ.Publicador;
import co.uco.bitacora.rabbitMQ.Suscription;
import co.uco.bitacora.repository.bitacora.IBitacoraDBRepository;
import co.uco.bitacora.repository.bitacora.IDescripcionRepository;
import co.uco.bitacora.repository.bitacora.IEstadoRepository;
import co.uco.bitacora.repository.usuario.ITipoUsuarioRepository;
import co.uco.bitacora.repository.usuario.IUsuarioRepository;
import co.uco.bitacora.service.check.ChekService;
import co.uco.bitacora.service.revision.RevisionService;
import jakarta.transaction.Transactional;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BitacoraService {


    @Autowired
    private Publicador publicador;

    @Autowired
    private Suscription suscripcion1;

    @Autowired
    private RabbitTemplate suscripcion;

    @Autowired
    private ITipoUsuarioRepository iTipoUsuarioRepository;
    @Autowired
    private IBitacoraDBRepository iBitacoraDBRepository;
    @Autowired
    private IDescripcionRepository iDescripcionRepository;
    @Autowired
    private IUsuarioRepository iUsuarioRepository;
    @Autowired
    private IEstadoRepository iEstadoRepository;
    @Autowired
    private ChekService chekService = new ChekService();
    @Autowired
    private RevisionService revisionService = new RevisionService();



    private Bitacora bitacoraAUX = new Bitacora();
    private BitacoraDB bitacoraDBAUX = new BitacoraDB();
    private Usuario usuarioAux = new Usuario();
    private Descripcion descripcionAux = new Descripcion();
    private TipoUsuario tipoUsuarioAux = new TipoUsuario();
    private Estado estadoAux = new Estado();
    private TipoEquipo tipoEquipoAux = new TipoEquipo();
    private Recomendacion recomendacionAux = new Recomendacion();


    public RespuestaAgendaCreada AgregarBitacoraAlaAgenda(userDescription usde) {
        List<Bitacora> bitacoras = new ArrayList<>();
        System.out.println("------------------------------------------------------------------------------------------------------------------------ va a crear una agenda");
        if (iUsuarioRepository.findById(usde.getIdUser()).isEmpty()) {
            return new RespuestaAgendaCreada("No existe el usuario");
        } else {

            try {
                //Aqui se Crea el usuario
                iUsuarioRepository.findById(usde.getIdUser()).ifPresent(dato -> {
                    usuarioAux = dato;
                });
                System.out.println(usuarioAux.getNombre());

                descripcionAux = new Descripcion(usde.getDesc());
                iDescripcionRepository.save(descripcionAux);


                System.out.println("Crea un Estado");
                estadoAux = new Estado();
                iEstadoRepository.save(estadoAux);

                System.out.println("Crea la bitacora");
                bitacoraDBAUX = new BitacoraDB(usuarioAux, descripcionAux, revisionService.revisionNuevaNula(), estadoAux);


                iBitacoraDBRepository.save(bitacoraDBAUX);

                return new RespuestaAgendaCreada();

            } catch (Exception e) {
                return new RespuestaAgendaCreada("salio un error 212121: " + e.getMessage());
            }
        }
    }

    public String actualizarDatosBasicos() {
        /* aqui se crea los datos estaticos de
         * tipo usuario ( 1 ó 2 y 3) ok
         * tipo equipo (1 ó 2 ó 3) ok
         * recomendaciones (arranca en 1 con el default) ok
         * estado (1 ó 2 ó 3 arranca en default con 1)
         * */

        try {
            //llenamos los tipo usuario
            tipoUsuarioAux = new TipoUsuario(1);
            iTipoUsuarioRepository.save(tipoUsuarioAux);

            tipoUsuarioAux = new TipoUsuario(2);
            iTipoUsuarioRepository.save(tipoUsuarioAux);

            tipoUsuarioAux = new TipoUsuario(3);
            iTipoUsuarioRepository.save(tipoUsuarioAux);

            //aqui creamos los estados posibles
            estadoAux = new Estado(1);
            iEstadoRepository.save(estadoAux);

            estadoAux = new Estado(2);
            iEstadoRepository.save(estadoAux);

            estadoAux = new Estado(3);
            iEstadoRepository.save(estadoAux);

            estadoAux = new Estado(4);
            iEstadoRepository.save(estadoAux);
            return "registro exitoso";
        } catch (Exception e) {
            return "Ocurrio un error: " + e.getMessage();
        }

    }

    public List<Bitacora> mostrarAgendaCompletadas() throws InterruptedException {
        List<BitacoraDB> listaBitacoraDB = iBitacoraDBRepository.findAll();
        List<Bitacora> bitacoras = new ArrayList<>();


        for (int i = 0; i < listaBitacoraDB.size(); i++) {
            Revision revision = new Revision();
            pedirRevisionAlProcesador(listaBitacoraDB.get(i).getRevision().getId());
            Thread.sleep(1000);
            Revision revision1 = suscripcion1.getRevision();

            revision.setId(revision1.getId());
            revision.setFechaFinal(revision1.getFechaFinal());
            revision.setEquipo(revision1.getEquipo());
            revision.setObservacion(revision1.getObservacion());
            revision.setChekList(revision1.getChekList());


            Bitacora bitacoraAUX1 = new Bitacora();

            bitacoraAUX1.setRevision(revision);

            bitacoraAUX1.setUsuario(listaBitacoraDB.get(i).getUsuario());
            bitacoraAUX1.setFechaEntrada(listaBitacoraDB.get(i).getFechaEntrada());
            bitacoraAUX1.setId(listaBitacoraDB.get(i).getId());
            bitacoraAUX1.setEstado(listaBitacoraDB.get(i).getEstado());
            bitacoraAUX1.setDescripcion(listaBitacoraDB.get(i).getDescription());
            if (bitacoraAUX1.getEstado().getNombre().equals("Completo")){
                bitacoras.add(bitacoraAUX1);
            }
        }

        return bitacoras;
    }

    public List<Bitacora> mostrarAgenda() throws InterruptedException {
        List<BitacoraDB> listaBitacoraDB = iBitacoraDBRepository.findAll();
        List<Bitacora> bitacoras = new ArrayList<>();


        for (int i = 0; i < listaBitacoraDB.size(); i++) {


            Revision revision = new Revision();
            pedirRevisionAlProcesador(listaBitacoraDB.get(i).getRevision().getId());
            Thread.sleep(1000);
            Revision revision1 = suscripcion1.getRevision();

            revision.setId(revision1.getId());
            revision.setFechaFinal(revision1.getFechaFinal());
            revision.setEquipo(revision1.getEquipo());
            revision.setObservacion(revision1.getObservacion());
            revision.setChekList(revision1.getChekList());


            Bitacora bitacoraAUX1 = new Bitacora();

            bitacoraAUX1.setRevision(revision);

            bitacoraAUX1.setUsuario(listaBitacoraDB.get(i).getUsuario());
            bitacoraAUX1.setFechaEntrada(listaBitacoraDB.get(i).getFechaEntrada());
            bitacoraAUX1.setId(listaBitacoraDB.get(i).getId());
            bitacoraAUX1.setEstado(listaBitacoraDB.get(i).getEstado());
            bitacoraAUX1.setDescripcion(listaBitacoraDB.get(i).getDescription());

            bitacoras.add(i, bitacoraAUX1);
        }

        return bitacoras;
    }

    @Transactional
    public RespuestaEquipoCreado editarEquipo(long idRevision, DatosEquipo actualizacion) {
        try {
            return new RespuestaEquipoCreado(revisionService.revisionNuevaconIdTipoequipo(idRevision, actualizacion.getTipoEquipo(), actualizacion.getMarca()));
        } catch (Exception e) {
            return new RespuestaEquipoCreado("no se actualizo");
        }
    }

    public List<Bitacora> mostrarPorUsuario(long id) throws InterruptedException {
        List<BitacoraDB> listaBitacoraDB = iBitacoraDBRepository.findAll();
        List<Bitacora> bitacoras = new ArrayList<>();


        for (int i = 0; i < listaBitacoraDB.size(); i++) {


            Revision revision = new Revision();
            pedirRevisionAlProcesador(listaBitacoraDB.get(i).getRevision().getId());
            Thread.sleep(1000);
            Revision revision1 = suscripcion1.getRevision();

            revision.setId(revision1.getId());
            revision.setFechaFinal(revision1.getFechaFinal());
            revision.setEquipo(revision1.getEquipo());
            revision.setObservacion(revision1.getObservacion());
            revision.setChekList(revision1.getChekList());


            Bitacora bitacoraAUX1 = new Bitacora();

            bitacoraAUX1.setRevision(revision);

            bitacoraAUX1.setUsuario(listaBitacoraDB.get(i).getUsuario());
            bitacoraAUX1.setFechaEntrada(listaBitacoraDB.get(i).getFechaEntrada());
            bitacoraAUX1.setId(listaBitacoraDB.get(i).getId());
            bitacoraAUX1.setEstado(listaBitacoraDB.get(i).getEstado());
            bitacoraAUX1.setDescripcion(listaBitacoraDB.get(i).getDescription());

            if (bitacoraAUX1.getUsuario().getId()==id){
                bitacoras.add(bitacoraAUX1);
            }
        }
        return bitacoras;
    }



    public void cancelarSolicitid(long id) {
        iBitacoraDBRepository.deleteById(id);
    }

    private void pedirRevisionAlProcesador(long id) {
        publicador.publicarColaC(id);
    }


}
