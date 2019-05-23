package com.omnicuris.ecommerce.ecommerce.controller;

import com.omnicuris.ecommerce.ecommerce.entity.Order;
import com.omnicuris.ecommerce.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping()
    public ResponseEntity createOder(@Valid @RequestBody Order order){
        orderService.placeOrder(order);
        return ResponseEntity.ok().body("Order has been place successfully");
    }

    @GetMapping("{id}")
    public Order getOrederById(@PathVariable(value = "id") Long id){
        return orderService.findOrderById(id);
    }

    @GetMapping()
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

}
