package co.uco.bitacora.controller.observacion;

import co.uco.bitacora.domain.objetoAuxiliar.ObservacionData;
import co.uco.bitacora.service.observacion.ObservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/procesador/bitacora/v1/observacion")
public class ObservacionController {

    @Autowired
    private ObservacionService observacionService = new ObservacionService();

    @PatchMapping("/observacion")
    @ResponseStatus(HttpStatus.CREATED)
    public String actualizarObservaciones(@RequestBody ObservacionData dato) throws InterruptedException {
        return observacionService.actualizarObservacion(dato);
    }




}
