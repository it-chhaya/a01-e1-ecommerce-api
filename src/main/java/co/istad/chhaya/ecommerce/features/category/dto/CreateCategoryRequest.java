package co.istad.chhaya.ecommerce.features.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCategoryRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50)
        String name,
        String description,
        String icon
) {
}
