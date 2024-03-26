package com.turkcell.spring.intro.controllers;

import com.turkcell.spring.intro.entities.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductsController
{
    // Route Params
    // Query String

    // http://localhost:8081/api/products?name=Halit&surname=Kalaycı GET - QUERY S. @RequestParam
    // http://localhost:8081/api/products/1 @PathVariable
    @GetMapping
    public String get(@RequestParam String name)
    {
        return "Merhaba " + name;
    }
    // http://localhost:8081/api/products/get2 GET
    @GetMapping("get2")
    public String get2()
    {
        return "Merhaba 2";
    }


    @PostMapping
    public Product post(@RequestBody Product product)
    {
        return product;
    }

    // Headers => YAN BİLGİ
    // Accept-Language =>
}
// Hibernate, ORM, JPA => Araştırmak
// ORM => Table to Java Class