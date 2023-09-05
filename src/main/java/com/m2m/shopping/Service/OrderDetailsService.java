package com.m2m.shopping.Service;

import com.m2m.shopping.entity.OrderDetails;

import java.util.List;

public interface OrderDetailsService {

    OrderDetails save(OrderDetails OrderDetails);
    OrderDetails create(OrderDetails OrderDetails);
    OrderDetails findById(Integer id);
    boolean delete(OrderDetails OrderDetails);

    List<OrderDetails> findAll();
}
