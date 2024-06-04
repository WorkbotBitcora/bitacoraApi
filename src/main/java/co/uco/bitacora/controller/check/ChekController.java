package co.uco.bitacora.controller.check;


import co.uco.bitacora.domain.objetoAuxiliar.DatoChek;
import co.uco.bitacora.domain.recomendacion.Recomendacion;
import co.uco.bitacora.domain.revision.Chek;
import co.uco.bitacora.service.check.ChekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procesador/bitacora/v1/chek")
public class ChekController {
    @Autowired
    private ChekService chekService = new ChekService();


    @GetMapping("/cheks/{tipo}")//ok paso pruebas
    public List<Chek> obtenerChecksPorTipo(@PathVariable long tipo) {
        return chekService.obtenerChecksPorId(tipo);
    }
    @GetMapping("/rec/{tipo}")//ok paso pruebas
    public List<Chek> recomendacionesPorIdRevision(@PathVariable long tipo) {
        return chekService.obtenerChecksPorId(tipo);
    }

    @PostMapping("/chekfinal/{idRevision}")
    public String llenarChecksActualizados(@PathVariable long idRevision , @RequestBody List<DatoChek> listaRespuesta) throws InterruptedException {
        return chekService.crearChekRevisadosConIdEquipoYIdRevision(idRevision, listaRespuesta);
    }
}
