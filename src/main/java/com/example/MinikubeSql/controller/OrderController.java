package com.example.MinikubeSql.controller;

import com.example.MinikubeSql.entity.Order;
import com.example.MinikubeSql.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepository repository;

    @PostMapping
    public Order addOrder(@RequestBody Order order){
        Order save = repository.save(order);
        System.out.println("order = " + save);
        return save;
    }

    @GetMapping
    public List<Order> getOrders(){
        List<Order> all = repository.findAll();
        System.out.println("orders = " + all);
        return all;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id){
        return repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid id : "+id));
    }
}
