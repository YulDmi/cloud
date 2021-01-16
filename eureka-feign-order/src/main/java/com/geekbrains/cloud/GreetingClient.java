package com.geekbrains.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.cloud.common.dto.ProductDto;

import java.util.List;

@FeignClient("eureka-client")
public interface GreetingClient {


    @RequestMapping("/products")
    List<ProductDto> getAllProducts();

    @GetMapping("/parametrized/{id}")
    String parametrized(@PathVariable(value = "id") String id);
}