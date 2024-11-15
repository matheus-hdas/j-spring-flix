package dev.matheushdas.springflix.controller;

import dev.matheushdas.springflix.dto.LoginRequest;
import dev.matheushdas.springflix.dto.LoginResponse;
import dev.matheushdas.springflix.dto.RegisterRequest;
import dev.matheushdas.springflix.dto.RegisterResponse;
import dev.matheushdas.springflix.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest userCredentials) {
        return ResponseEntity.status(HttpStatus.OK).body(service.login(userCredentials));
    }
}
