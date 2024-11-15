package dev.matheushdas.springflix.mapper;

import dev.matheushdas.springflix.dto.RegisterRequest;
import dev.matheushdas.springflix.dto.RegisterResponse;
import dev.matheushdas.springflix.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(RegisterRequest data) {
        return new User(
                data.name(),
                data.email(),
                data.password()
        );
    }

    public RegisterResponse toResponse(User data) {
        return new RegisterResponse(
                data.getId(),
                data.getName(),
                data.getEmail()
        );
    }
}
