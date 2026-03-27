package co.istad.chhaya.webmvc.service;

import co.istad.chhaya.webmvc.dto.CreateProductRequest;
import co.istad.chhaya.webmvc.dto.ProductResponse;
import co.istad.chhaya.webmvc.dto.UpdateProductRequest;
import org.springframework.data.domain.Page;

public interface ProductService {


    ProductResponse getProductByCode(String code);

    ProductResponse updateByCode(String code, UpdateProductRequest updateProductRequest);

    Page<ProductResponse> getProducts(int pageNumber, int pageSize);

    ProductResponse createNew(CreateProductRequest createProductRequest);

}
