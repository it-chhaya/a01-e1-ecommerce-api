package co.istad.chhaya.ecommerce.features.category;

import co.istad.chhaya.ecommerce.features.category.dto.CategoryResponse;
import co.istad.chhaya.ecommerce.features.category.dto.CreateCategoryRequest;
import org.springframework.data.domain.Page;

public interface CategoryService {


    Page<CategoryResponse> findAll(int pageNumber, int pageSize);


    CategoryResponse createNew(CreateCategoryRequest createCategoryRequest);

}
