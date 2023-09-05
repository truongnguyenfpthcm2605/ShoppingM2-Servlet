package com.m2m.shopping.Service;

import com.m2m.shopping.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(Product Product);
    Product create(Product Product);
    Product findById(Integer id);
    boolean delete(Product Product);

    List<Product> findAll();
}
