package dev.matheushdas.springflix.service;

import dev.matheushdas.springflix.dto.CategoryResponse;
import dev.matheushdas.springflix.dto.CreateCategoryRequest;
import dev.matheushdas.springflix.mapper.CategoryMapper;
import dev.matheushdas.springflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public List<CategoryResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public CategoryResponse save(CreateCategoryRequest category) {
        return mapper.toResponse(
                repository.save(mapper.toEntity(category)));
    }

    public CategoryResponse findById(Long id) {
        return mapper.toResponse(repository.findById(id).orElseThrow());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
