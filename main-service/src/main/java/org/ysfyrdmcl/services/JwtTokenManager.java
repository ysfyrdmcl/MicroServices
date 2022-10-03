package org.ysfyrdmcl.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtTokenManager {

    public boolean validateToken(String token){
       try {
           Algorithm algorithm=Algorithm.HMAC256("12345");
           JWTVerifier verifier = JWT.require(algorithm)
                   .withIssuer("ysf")
                   .build();
           DecodedJWT decode = verifier.verify(token);
           if(decode==null)
               return false;
       }
       catch (Exception ex){
           return false;
       }
        return true;

    }

    public Optional<Long>getUserId(String token){
        try {
            Algorithm algorithm=Algorithm.HMAC256("12345");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("ysf")
                    .build();
            DecodedJWT decode = verifier.verify(token);
            if(decode==null)
                return Optional.empty();
            return Optional.of(decode.getClaim("id").asLong());
        }
        catch (Exception ex){
            return Optional.empty();
        }

    }
}
