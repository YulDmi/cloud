package com.geekbrains.cloud;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();

    }
    public Product save(Product product){
      return  productRepository.save(product);
    }
}
