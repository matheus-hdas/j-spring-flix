package dev.matheushdas.springflix.mapper;

import dev.matheushdas.springflix.dto.CreateMovieRequest;
import dev.matheushdas.springflix.dto.MovieResponse;
import dev.matheushdas.springflix.dto.UpdateMovieRequest;
import dev.matheushdas.springflix.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public Movie toEntity(CreateMovieRequest data) {
        return new Movie(
                data.title(),
                data.description(),
                data.releaseDate(),
                data.rating(),
                data.createdAt(),
                data.updatedAt(),
                data.categories(),
                data.streamings()
        );
    }

    public Movie toEntity(UpdateMovieRequest data) {
        return new Movie(
                data.id(),
                data.title(),
                data.description(),
                data.releaseDate(),
                data.rating(),
                data.createdAt(),
                data.updatedAt(),
                data.categories(),
                data.streamings()
        );
    }

    public MovieResponse toResponse(Movie data) {
        return new MovieResponse(
                data.getId(),
                data.getTitle(),
                data.getDescription(),
                data.getReleaseDate(),
                data.getRating(),
                data.getCreatedAt(),
                data.getUpdatedAt(),
                data.getCategories(),
                data.getStreamings()
        );
    }
}
