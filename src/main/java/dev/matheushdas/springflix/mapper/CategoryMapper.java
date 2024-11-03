package dev.matheushdas.springflix.mapper;

import dev.matheushdas.springflix.dto.CategoryDTO;
import dev.matheushdas.springflix.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Category toEntity(CategoryDTO data) {
        return modelMapper.map(data, Category.class);
    }

    public CategoryDTO toDto(Category data) {
        return modelMapper.map(data, CategoryDTO.class);
    }
}
