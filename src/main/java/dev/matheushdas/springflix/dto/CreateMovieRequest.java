package dev.matheushdas.springflix.dto;

import dev.matheushdas.springflix.entity.Category;
import dev.matheushdas.springflix.entity.Streaming;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CreateMovieRequest(String title,
                                 String description,
                                 LocalDate releaseDate,
                                 Double rating,
                                 LocalDateTime createdAt,
                                 LocalDateTime updatedAt,
                                 List<Category> categories,
                                 List<Streaming> streamings) {
}
