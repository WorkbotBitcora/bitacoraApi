package co.uco.bitacora.controller.bitacora;

import co.uco.bitacora.domain.bitacora.Bitacora;
import co.uco.bitacora.domain.bitacora.BitacoraDB;
import co.uco.bitacora.domain.bitacora.RespuestaAgendaCreada;
import co.uco.bitacora.domain.equipo.RespuestaEquipoCreado;
import co.uco.bitacora.domain.objetoAuxiliar.DatosEquipo;
import co.uco.bitacora.domain.usuario.userDescription;
import co.uco.bitacora.service.bitacora.BitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/procesador/bitacora/v1/bitacora")
public class BitacoraController {


    @Autowired
    private BitacoraService serviciosDeBitacora = new BitacoraService();



    @PostMapping("/cargarDB")// paso pruebas
    public String llenardata(){
        return serviciosDeBitacora.actualizarDatosBasicos();
    }




    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/agendalista")//
    public ResponseEntity<List<Bitacora>> mostrarAgenda() throws InterruptedException {
        return ResponseEntity.ok(serviciosDeBitacora.mostrarAgenda());
    }


    @GetMapping("/agendalista/completadas")//
    public ResponseEntity<List<Bitacora>> mostrarAgendaCompletadas() throws InterruptedException {
        return ResponseEntity.ok(serviciosDeBitacora.mostrarAgendaCompletadas());
    }

    //@PatchMapping( value = "/equipo/{dato}")
    @PatchMapping( value = "/equipo/{idRevision}")//ok paso pruebas
    @ResponseStatus(HttpStatus.ACCEPTED)
    public RespuestaEquipoCreado actualizarEquipo (@PathVariable long idRevision , @RequestBody DatosEquipo actualizacion){
        //LA BUSQUEDA SE HACE POR EL ID DE LA REVISION
        return serviciosDeBitacora.editarEquipo(idRevision , actualizacion);
    }

    @PostMapping("/agenda")
    @ResponseStatus(HttpStatus.CREATED)  //ok
    public RespuestaAgendaCreada ingresarRegistro(@RequestBody userDescription usde){
        return serviciosDeBitacora.AgregarBitacoraAlaAgenda(usde);
    }

    @GetMapping("/usuario/{id}")//ok paso pruebas
    public ResponseEntity<List<Bitacora>> mostarPorUsuario(@PathVariable long id) throws InterruptedException {
        return ResponseEntity.ok(serviciosDeBitacora.mostrarPorUsuario(id));
    }


    @DeleteMapping("/usuario/{id}")//ok paso pruebas
    public void calcelarSolicitud(@PathVariable long id){
        serviciosDeBitacora.cancelarSolicitid(id);
    }

}
