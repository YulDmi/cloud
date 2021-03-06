package com.geekbrains.cloud;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();

    }
//    public List<Order> findAllByUserId(Long userId){
//        return orderRepository.findAllByUserId(userId);
//    }
    public Order save(Order order){
      return  orderRepository.save(order);
    }
}
