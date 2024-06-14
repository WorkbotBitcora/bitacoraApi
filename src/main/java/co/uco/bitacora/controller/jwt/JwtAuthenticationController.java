package co.uco.bitacora.controller.jwt;

import co.uco.bitacora.domain.jwt.JwtResponse;
import co.uco.bitacora.domain.objetoAuxiliar.EditableUsuario;
import co.uco.bitacora.domain.objetoAuxiliar.Login;
import co.uco.bitacora.domain.usuario.RespuestaUsuarioRegistro;
import co.uco.bitacora.domain.usuario.RespuetaUsuarioLogin;
import co.uco.bitacora.rabbitMQ.Publicador;
import co.uco.bitacora.service.jwt.JwtAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/procesador/bitacora/v1/Authentication")
@RequiredArgsConstructor
public class JwtAuthenticationController {

    @Autowired
    private Publicador publicador;

    @Autowired
    private JwtAuthenticationService jwtAuthenticationService = new JwtAuthenticationService();



    @PostMapping(value = "/log")
    public ResponseEntity<RespuetaUsuarioLogin> login(@RequestBody Login login) {
        return ResponseEntity.ok(jwtAuthenticationService.login(login));
    }

    @PostMapping(value = "/reg")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RespuestaUsuarioRegistro> registrar(@RequestBody EditableUsuario editableUsuario) {
        return ResponseEntity.ok(jwtAuthenticationService.registrar(editableUsuario));
    }

}
