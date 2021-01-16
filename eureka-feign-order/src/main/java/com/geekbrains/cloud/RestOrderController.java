package com.geekbrains.cloud;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.cloud.common.dto.ProductDto;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class RestOrderController {
    private final OrderService orderService;
    private final GreetingClient greetingClient;

    @RequestMapping("/products")
    public List<ProductDto> getAllProducts() {
       List<ProductDto> list = greetingClient.getAllProducts();
        return list;
    }

    @GetMapping
    private List<Order> getAllOrders() {

        return orderService.findAll();
    }

    @PostMapping
    public void saveOrder(@RequestParam Integer price,
                          @RequestParam Integer quantity
                          ) {
        Order order = new Order();
        order.setPrice(price);
        order.setQuantity(quantity);
        orderService.save(order);
    }
}
