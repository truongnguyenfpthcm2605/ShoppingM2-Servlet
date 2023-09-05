package com.m2m.shopping.Service;

import com.m2m.shopping.entity.Order;

import java.util.List;

public interface OrderService {

    Order save(Order Order);
    Order create(Order Order);
    Order findById(Integer id);
    boolean delete(Order Order);
    List<Order> findAll();
}
