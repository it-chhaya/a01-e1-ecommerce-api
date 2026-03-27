package co.istad.chhaya.webmvc.mapper;

import co.istad.chhaya.webmvc.domain.Product;
import co.istad.chhaya.webmvc.dto.PatchProductRequest;
import co.istad.chhaya.webmvc.dto.ProductResponse;
import co.istad.chhaya.webmvc.dto.UpdateProductRequest;
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
