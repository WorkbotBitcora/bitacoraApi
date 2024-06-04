package co.uco.bitacora.service.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String LLAVE = "84efc89ef6b14648bdb12bcdc085160584efc89ef6b14648bdb12bcdc0851605";

    public String optenertoken(UserDetails usuarioAux) {
        return getToken(new HashMap<>(),usuarioAux);
    }

    private String getToken(Map<String, Object> extraClaims, UserDetails usuarioAux) {

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(usuarioAux.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(optenerLlave(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key optenerLlave() {
        byte[] kBytes= Decoders.BASE64.decode(LLAVE);
        return Keys.hmacShaKeyFor(kBytes);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String nombreDeUsuario = optenerNombreUsuarioPorToken(token);
        return (nombreDeUsuario.equals(userDetails.getUsername()) && !esValidoElToken(token));
    }

    public String optenerNombreUsuarioPorToken(String token) {
        return optenerClaim(token, Claims::getSubject);
    }

    private Claims optenerTodosLosClains(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(optenerLlave())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T>T optenerClaim(String token , Function<Claims,T> claims){
        final Claims claims1 = optenerTodosLosClains(token);
        return claims.apply(claims1);
    }
    private Date optenerFechaExpiracion(String token){
        return optenerClaim(token, Claims::getExpiration);
    }

    private boolean esValidoElToken (String token){
        return optenerFechaExpiracion(token).before(new Date());
    }

}
