package mate.academy.service;

import java.util.List;
import mate.academy.dto.CategoryDto;
import mate.academy.dto.CreateCategoryRequestDto;
import mate.academy.model.Category;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    List<CategoryDto> findAll(Pageable pageable);

    CategoryDto findById(Long categoryName);

    Category save(CreateCategoryRequestDto createCategoryRequestDto);

    CategoryDto update(Long id, CreateCategoryRequestDto requestDto);

    void deleteById(Long id);
}
