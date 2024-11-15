package dev.matheushdas.springflix.service;

import dev.matheushdas.springflix.dto.CreateMovieRequest;
import dev.matheushdas.springflix.dto.MovieResponse;
import dev.matheushdas.springflix.dto.UpdateMovieRequest;
import dev.matheushdas.springflix.entity.Movie;
import dev.matheushdas.springflix.mapper.MovieMapper;
import dev.matheushdas.springflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository repository;
    private final MovieMapper mapper;

    public List<MovieResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public MovieResponse findById(Long id) {
        return mapper.toResponse(repository.findById(id).orElseThrow());
    }

    public MovieResponse save(CreateMovieRequest movie) {
        return mapper.toResponse(repository.save(mapper.toEntity(movie)));
    }

    public MovieResponse update(UpdateMovieRequest movie) {
        Movie toUpdate = repository.findById(movie.id()).orElseThrow();
        toUpdate.setTitle(movie.title());
        toUpdate.setDescription(movie.description());
        toUpdate.setRating(movie.rating());
        toUpdate.setReleaseDate(movie.releaseDate());

        toUpdate.getCategories().clear();
        toUpdate.getCategories().addAll(movie.categories());

        toUpdate.getStreamings().clear();
        toUpdate.getStreamings().addAll(movie.streamings());

        return mapper.toResponse(repository.save(toUpdate));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
