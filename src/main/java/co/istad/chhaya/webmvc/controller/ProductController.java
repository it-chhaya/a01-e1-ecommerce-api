package co.istad.chhaya.webmvc.controller;

import co.istad.chhaya.webmvc.dto.CreateProductRequest;
import co.istad.chhaya.webmvc.dto.ProductResponse;
import co.istad.chhaya.webmvc.dto.UpdateProductRequest;
import co.istad.chhaya.webmvc.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/{code}")
    public ProductResponse getProductByCode(
            @PathVariable Integer code
    ) {
        log.info("getProductByCode: {}", code);

        return null;
    }

    @GetMapping
    public Page<ProductResponse> getProducts(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "25") int pageSize
    ) {
        return productService.getProducts(pageNumber, pageSize);
    }



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductResponse createNew(
            @Valid @RequestBody CreateProductRequest createProductRequest
    ) {
        log.info("createProductRequest: {}", createProductRequest);
        return productService.createNew(createProductRequest);
    }



    @PutMapping("/{code}")
    public ProductResponse updateByCode(
            @PathVariable Integer code,
            @RequestBody UpdateProductRequest updateProductRequest
    ) {
        log.info("updateProductRequest: {} and code: {}",
                updateProductRequest,
                code);
        return null;
    }

    @PatchMapping("/{code}")
    public ProductResponse patchByCode(
            @PathVariable Integer code,
            @RequestBody UpdateProductRequest updateProductRequest
    ) {
        log.info("patchProductRequest: {} and code: {}",
                updateProductRequest,
                code);
        return null;
    }


    @DeleteMapping("/{code}")
    public void deleteByCode(@PathVariable Integer code) {
        log.info("deleteByCode: {}", code);
    }

}
