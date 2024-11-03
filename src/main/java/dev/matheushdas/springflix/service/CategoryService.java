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
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .toList();
    }

    public CategoryDTO save(CategoryDTO category) {
        return categoryMapper.toDto(
                categoryRepository.save(categoryMapper.toEntity(category)));
    }

    public CategoryDTO findById(Long id) {
        return categoryMapper.toDto(categoryRepository.findById(id).orElse(null));
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
