package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.dao.ProblemDao;
import bo.edu.ucb.sis.piratebay.model.ProblemModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/problems")
public class ProblemController {

    @Autowired
    ProblemDao problemDao;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProblem(
            @RequestHeader("Authorization") String authorization,
            @RequestBody ProblemModel problemModel,
            @PathParam("orderId") Integer orderId
            ) {

        // Lo unico que estamos haciendo es decodificar el token.
        String tokenJwT = authorization.substring(7);
        System.out.println("TOKEN JWT: " + tokenJwT);
        DecodedJWT decodedJWT = JWT.decode(tokenJwT);
        String idUsuario = decodedJWT.getSubject();
        System.out.println("USUARIO: " + idUsuario);

        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString()) ) {
            throw new RuntimeException("El token proporcionado no es un token de Autenthication");
        }
        // El siguiente código valida si el token es bueno y ademas es un token de authentication

        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("PirateBay")
                .build();
        verifier.verify(tokenJwT);

        return new ResponseEntity(problemDao.createProblem(orderId,problemModel), HttpStatus.OK);
    }
}
