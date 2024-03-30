package com.turkcell.spring.intro.services.abstracts;

import com.turkcell.spring.intro.services.dtos.requests.product.AddProductRequest;

public interface ProductService {
    // TODO: Add AddProductResponse
    void add(AddProductRequest request);
}
