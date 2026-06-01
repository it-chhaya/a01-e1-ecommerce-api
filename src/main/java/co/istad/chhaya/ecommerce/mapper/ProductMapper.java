package co.istad.chhaya.ecommerce.mapper;

import co.istad.chhaya.ecommerce.domain.Product;
import co.istad.chhaya.ecommerce.dto.PatchProductRequest;
import co.istad.chhaya.ecommerce.dto.ProductResponse;
import co.istad.chhaya.ecommerce.dto.UpdateProductRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "category.name", target = "categoryName")
    ProductResponse productToProductResponse(Product product);

    void updateProductRequestToProduct(UpdateProductRequest updateProductRequest,
                                       @MappingTarget Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchProductRequestToProduct(PatchProductRequest patchProductRequest,
                                       @MappingTarget Product product);

}
