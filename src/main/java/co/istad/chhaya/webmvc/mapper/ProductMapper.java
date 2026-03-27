package co.istad.chhaya.webmvc.mapper;

import co.istad.chhaya.webmvc.domain.Product;
import co.istad.chhaya.webmvc.dto.ProductResponse;
import co.istad.chhaya.webmvc.dto.UpdateProductRequest;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponse productToProductResponse(Product product) {
        return ProductResponse.builder()
                .code(product.getCode())
                .name(product.getName())
                .price(product.getPrice())
                .qty(product.getQty())
                .description(product.getDescription())
                .isAvailable(product.getIsAvailable())
                .categoryName(product.getCategory().getName())
                .build();
    }

    public void updateProductRequestToProduct(UpdateProductRequest updateProductRequest,
                                                 Product product) {
        product.setName(updateProductRequest.name());
        product.setDescription(updateProductRequest.description());
        product.setQty(updateProductRequest.qty());
        product.setPrice(updateProductRequest.price());
    }

}
