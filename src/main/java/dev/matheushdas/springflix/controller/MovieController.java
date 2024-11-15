package dev.matheushdas.springflix.controller;

import dev.matheushdas.springflix.dto.CreateMovieRequest;
import dev.matheushdas.springflix.dto.MovieResponse;
import dev.matheushdas.springflix.dto.UpdateMovieRequest;
import dev.matheushdas.springflix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService service;

    @GetMapping("/all")
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable Long id) {
        MovieResponse movie = service.findById(id);

        return movie == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(movie);
    }

    @PostMapping("/save")
    public ResponseEntity<MovieResponse> saveMovie(@RequestBody CreateMovieRequest movie) {
        return ResponseEntity.status(HttpStatus.CREATED)
               .body(service.save(movie));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@RequestBody UpdateMovieRequest movie) {
        return ResponseEntity.ok(service.update(movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
