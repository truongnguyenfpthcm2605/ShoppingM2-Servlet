package com.m2m.shopping.Service.Impl;

import com.m2m.shopping.Service.ProductService;
import com.m2m.shopping.entity.Product;
import com.m2m.shopping.repository.JpaRepository;

import java.util.List;

public class ProductServiceImpl extends JpaRepository<Product> implements ProductService {

    @Override
    public Product findById(Integer id) {
        return super.findByid(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        return super.findAll(Product.class, true);
    }

    @Override
    public boolean delete(Product product) {
        product.setIsActive(false);
        super.save(product);
        return true;
    }
}
