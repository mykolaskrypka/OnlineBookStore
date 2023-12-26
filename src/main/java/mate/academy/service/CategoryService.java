package mate.academy.service;

import java.util.List;
import mate.academy.dto.CategoryDto;
import mate.academy.model.Category;

public interface CategoryService {

    List<Category> findAll();

    Category getById(Long categoryName);

    Category save(Category category);

    CategoryDto update(Long id, CategoryDto categoryDto);

    void deleteById(Long id);
}
