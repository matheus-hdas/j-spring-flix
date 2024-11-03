package dev.matheushdas.springflix.service;

import dev.matheushdas.springflix.dto.CategoryDTO;
import dev.matheushdas.springflix.mapper.CategoryMapper;
import dev.matheushdas.springflix.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private CategoryMapper mapper;

    public List<CategoryDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public CategoryDTO save(CategoryDTO category) {
        return mapper.toDto(
                repository.save(mapper.toEntity(category)));
    }

    public CategoryDTO findById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
