package dev.matheushdas.springflix.service;

import dev.matheushdas.springflix.config.jwt.TokenProvider;
import dev.matheushdas.springflix.dto.LoginRequest;
import dev.matheushdas.springflix.dto.LoginResponse;
import dev.matheushdas.springflix.dto.RegisterRequest;
import dev.matheushdas.springflix.dto.RegisterResponse;
import dev.matheushdas.springflix.entity.User;
import dev.matheushdas.springflix.mapper.UserMapper;
import dev.matheushdas.springflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;
    private final AuthenticationManager manager;
    private final TokenProvider tokenProvider;

    public RegisterResponse save(RegisterRequest user) {
        User encrypted = mapper.toEntity(user);
        encrypted.setPassword(encoder.encode(encrypted.getPassword()));
        return mapper.toResponse(repository.save(encrypted));
    }

    public LoginResponse login(LoginRequest userCredentials) {
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(userCredentials.email(), userCredentials.password());
        Authentication authenticate = manager.authenticate(userAndPass);

        User user = (User) authenticate.getPrincipal();

        return new LoginResponse(tokenProvider.generateToken(user));
    }
}
