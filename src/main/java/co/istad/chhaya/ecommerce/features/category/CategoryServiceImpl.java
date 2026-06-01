package co.istad.chhaya.ecommerce.features.category;

import co.istad.chhaya.ecommerce.features.category.dto.CategoryResponse;
import co.istad.chhaya.ecommerce.features.category.dto.CreateCategoryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public Page<CategoryResponse> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize,
                Sort.by( Sort.Direction.DESC, "id"));
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categories.map(categoryMapper::mapCategoryToCategoryResponse);
    }



    @Override
    public CategoryResponse createNew(CreateCategoryRequest createCategoryRequest) {
        log.info("Create new category request: {}", createCategoryRequest);

        Category category = categoryMapper
                .mapCreateCategoryRequestToCategory(createCategoryRequest);

        category = categoryRepository.save(category);

        return categoryMapper.mapCategoryToCategoryResponse(category);
    }

}
