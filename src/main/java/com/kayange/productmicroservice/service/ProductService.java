package com.kayange.productmicroservice.service;

import com.kayange.productmicroservice.dto.ProductRequest;
import com.kayange.productmicroservice.dto.ProductResponse;
import com.kayange.productmicroservice.model.Product;

import com.kayange.productmicroservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder().price(productRequest.getPrice())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        Product productDB = productRepository.save(product);

        return  ProductResponse
                .builder()
                .id(productDB.getId())
                .name(productDB.getName())
                .description(productDB.getDescription())
                .price(productDB.getPrice())
                .build();
    }
}
