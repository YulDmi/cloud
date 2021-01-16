package com.geekbrains.cloud;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ProductService {

    private static Map<Long, Product> map = new HashMap<>();
    private ProductRepository productRepository;

    public List<Product> findAll() {
        long count = productRepository.count();
        if ((long)map.size() != count){
            List<Product> products = productRepository.findAll();
           products.forEach(product -> map.put(product.getId(), product));
            return products;
        }else {
            return new ArrayList<>(map.values());
        }
    }

    public Product save(Product product) {

        Product p = productRepository.save(product);
        map.put(p.getId(), p);
        return p;
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
        map.remove(id);

    }

    public Product getProduct(Long id) {
        if(map.containsKey(id)){
            return map.get(id);
        }
        Product p = productRepository.findById(id).orElse(null);
        if(p != null){
            map.put(id, p);
        }
        return p;
    }

}
