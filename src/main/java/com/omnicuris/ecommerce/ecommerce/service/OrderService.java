package com.omnicuris.ecommerce.ecommerce.service;

import com.omnicuris.ecommerce.ecommerce.entity.Item;
import com.omnicuris.ecommerce.ecommerce.entity.Order;
import com.omnicuris.ecommerce.ecommerce.entity.User;
import com.omnicuris.ecommerce.ecommerce.exception.OrderException;
import com.omnicuris.ecommerce.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    public void placeOrder(Order order){
        //checking the user exists or not
        User user = userService.findUserByEmailId(order.getEmailId());

        //checking the placed item exists or not
        Item item = itemService.getItemById(order.getItemId());

        //checking the stock availability
        if(item.getAvailableQty()<order.getNoOfItems()){
            throw new OrderException("don't have the required quantity for the stock");
        }

        //updating the new stock availability
        Long currAvailableQty = item.getAvailableQty() - order.getNoOfItems();
        item.setAvailableQty(currAvailableQty);
        itemService.saveItem(item);

        //saving the order
        orderRepository.save(order);
    }

    public Order findOrderById(Long id){
        return orderRepository.findById(id)
                .orElseThrow(()-> new OrderException("No Order exists with the id: "+id.toString()));
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}
