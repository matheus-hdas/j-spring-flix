package dev.matheushdas.springflix.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import dev.matheushdas.springflix.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenProvider {

    @Value("${api.security.secret}")
    private String secret;

    public String generateToken(User user) {
        Algorithm alg = Algorithm.HMAC256(secret);
        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("userId", user.getId())
                .withExpiresAt(Instant.now().plusSeconds(7200))
                .withIssuer("springflix-api")
                .sign(alg);
    }
}
