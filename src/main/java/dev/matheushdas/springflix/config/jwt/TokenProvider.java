package dev.matheushdas.springflix.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import dev.matheushdas.springflix.dto.JWTUserData;
import dev.matheushdas.springflix.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenProvider {

    @Value("${api.security.secret}")
    private String secret;
    private final Algorithm alg = Algorithm.HMAC256(secret);

    public String generateToken(User user) {

        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("userId", user.getId())
                .withClaim("userName", user.getName())
                .withExpiresAt(Instant.now().plusSeconds(7200))
                .withIssuer("springflix-api")
                .sign(alg);
    }

    public Optional<JWTUserData> validateToken(String token) {
        try {
            DecodedJWT jwt = JWT.require(alg)
                    .build()
                    .verify(token);

            return Optional.of(new JWTUserData(
                    jwt.getClaim("userId").asLong(),
                    jwt.getClaim("userName").asString(),
                    jwt.getSubject()
            ));
        } catch (JWTVerificationException ex) {
            return Optional.empty();
        }
    }
}
