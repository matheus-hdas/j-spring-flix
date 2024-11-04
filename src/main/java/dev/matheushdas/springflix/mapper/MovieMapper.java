package dev.matheushdas.springflix.mapper;

import dev.matheushdas.springflix.dto.MovieDTO;
import dev.matheushdas.springflix.entity.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    @Autowired
    private ModelMapper mapper;

    public Movie toEntity(MovieDTO data) {
        return mapper.map(data, Movie.class);
    }

    public MovieDTO toDto(Movie data) {
        return mapper.map(data, MovieDTO.class);
    }
}
