package dev.matheushdas.springflix.controller;

import dev.matheushdas.springflix.dto.LoginRequest;
import dev.matheushdas.springflix.dto.LoginResponse;
import dev.matheushdas.springflix.dto.RegisterRequest;
import dev.matheushdas.springflix.dto.RegisterResponse;
import dev.matheushdas.springflix.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest userCredentials) {
        return ResponseEntity.status(HttpStatus.OK).body(service.login(userCredentials));
    }
}
