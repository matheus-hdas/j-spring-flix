package dev.matheushdas.springflix.service;

import dev.matheushdas.springflix.dto.MovieDTO;
import dev.matheushdas.springflix.entity.Movie;
import dev.matheushdas.springflix.mapper.MovieMapper;
import dev.matheushdas.springflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private MovieMapper mapper;

    public List<MovieDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public MovieDTO findById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    public MovieDTO save(MovieDTO movie) {
        return mapper.toDto(repository.save(mapper.toEntity(movie)));
    }

    public MovieDTO update(MovieDTO movie) {
        Movie toUpdate = repository.findById(movie.getId()).orElseThrow();
        toUpdate.setTitle(movie.getTitle());
        toUpdate.setDescription(movie.getDescription());
        toUpdate.setRating(movie.getRating());
        toUpdate.setReleaseDate(movie.getReleaseDate());

        toUpdate.getCategories().clear();
        toUpdate.getCategories().addAll(movie.getCategories());

        toUpdate.getStreamings().clear();
        toUpdate.getStreamings().addAll(movie.getStreamings());

        return mapper.toDto(repository.save(toUpdate));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
