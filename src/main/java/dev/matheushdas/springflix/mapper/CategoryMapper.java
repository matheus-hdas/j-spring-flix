package dev.matheushdas.springflix.mapper;

import dev.matheushdas.springflix.dto.CategoryResponse;
import dev.matheushdas.springflix.dto.CreateCategoryRequest;
import dev.matheushdas.springflix.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CreateCategoryRequest data) {
        return new Category(
                data.name()
        );
    }

    public CategoryResponse toResponse(Category data) {
        return new CategoryResponse(
                data.getId(),
                data.getName()
        );
    }
}
