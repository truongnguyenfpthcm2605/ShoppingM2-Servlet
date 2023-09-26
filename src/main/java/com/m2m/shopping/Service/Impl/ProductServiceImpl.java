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

    public Product create(Product enity) {
        return super.create(enity);
    }

    @Override
    public Product save(Product enity) {
        return super.save(enity);
    }

    @Override
    public boolean delete(Product enity) {
        product.setIsActive(false);
        if (super.save(product) != null) {
            return true;
        }
        return false;
    }
}
