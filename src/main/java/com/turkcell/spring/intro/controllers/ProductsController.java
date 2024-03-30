package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.Product;
import com.turkcell.spring.intro.services.abstracts.ProductService;
import com.turkcell.spring.intro.services.dtos.requests.product.AddProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsController
{
    private final ProductService productService;

    @PostMapping
    public void add(@RequestBody AddProductRequest request)
    {
        productService.add(request);
    }
}
