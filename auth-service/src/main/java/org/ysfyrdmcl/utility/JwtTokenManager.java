package org.ysfyrdmcl.utility;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.Optional;
@Service
public class JwtTokenManager {

    public Optional<String> createToken(Long id){
        String sifreAnahtari = "12345";

        try{
            String token = JWT.create()
                    .withAudience()
                    .withClaim("id",id)
                    .withIssuer("ysf")
                    .withExpiresAt(new Date(System.currentTimeMillis()+1000*60))
                    .withIssuedAt(new Date())
                    .sign(Algorithm.HMAC256(sifreAnahtari));
            return Optional.of(token);
        }
        catch (Exception e){
            return Optional.empty();
        }
    }
}
