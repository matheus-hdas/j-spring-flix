package dev.matheushdas.springflix.service;

import dev.matheushdas.springflix.dto.RegisterRequest;
import dev.matheushdas.springflix.dto.RegisterResponse;
import dev.matheushdas.springflix.mapper.UserMapper;
import dev.matheushdas.springflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    public RegisterResponse save(RegisterRequest user) {
        return mapper.toResponse(repository.save(mapper.toEntity(user)));
    }
}
