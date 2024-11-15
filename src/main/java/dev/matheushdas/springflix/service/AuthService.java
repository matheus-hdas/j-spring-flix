package dev.matheushdas.springflix.service;

import dev.matheushdas.springflix.dto.RegisterRequest;
import dev.matheushdas.springflix.dto.RegisterResponse;
import dev.matheushdas.springflix.entity.User;
import dev.matheushdas.springflix.mapper.UserMapper;
import dev.matheushdas.springflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public RegisterResponse save(RegisterRequest user) {
        User encrypted = mapper.toEntity(user);
        encrypted.setPassword(passwordEncoder.encode(encrypted.getPassword()));
        return mapper.toResponse(repository.save(encrypted));
    }
}
