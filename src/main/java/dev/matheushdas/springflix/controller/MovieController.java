package dev.matheushdas.springflix.controller;

import dev.matheushdas.springflix.dto.MovieDTO;
import dev.matheushdas.springflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/all")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long id) {
        MovieDTO movie = service.findById(id);

        return movie == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(movie);
    }

    @PostMapping("/save")
    public ResponseEntity<MovieDTO> saveMovie(@RequestBody MovieDTO movie) {
        return ResponseEntity.status(HttpStatus.CREATED)
               .body(service.save(movie));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MovieDTO> updateMovie(@RequestBody MovieDTO movie) {
        return ResponseEntity.ok(service.update(movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
