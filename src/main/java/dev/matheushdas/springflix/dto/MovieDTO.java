package dev.matheushdas.springflix.dto;

import dev.matheushdas.springflix.entity.Category;
import dev.matheushdas.springflix.entity.Streaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private Double rating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Category> categories;
    private List<Streaming> streamings;
}
