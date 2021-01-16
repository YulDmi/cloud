package com.geekbrains.cloud;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.cloud.common.dto.ProductDto;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class RestProductController {
    private final ProductService productService;


    @GetMapping
    private List<ProductDto> getAllProducts() {

        return productService.findAll().stream().map(product -> {
            ProductDto productDto = new ProductDto();
            productDto.setName(product.getName());
            productDto.setPrice(product.getPrice());
            return productDto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void saveProduct(@RequestParam String name,
                          @RequestParam Integer price

    ) {
        Product product = new Product();
        product.setPrice(price);
        product.setName(name);
        productService.save(product);
    }
}
