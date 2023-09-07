package com.m2m.shopping.Service.Impl;

import com.m2m.shopping.Service.CategoriesService;
import com.m2m.shopping.entity.Categories;
import com.m2m.shopping.repository.JpaRepository;

import java.util.List;

public class CategoriesServiceImpl  extends JpaRepository<Categories> implements CategoriesService {
    @Override
    public Categories findById(Integer id) {
        return super.findByid(Categories.class, id);
    }

    @Override
    public List<Categories> findAll() {
        return super.findAll(Categories.class, false);
    }

    @Override
    public Categories create(Categories enity) {
        return super.create(enity);
    }

    @Override
    public Categories save(Categories enity) {
        return super.save(enity);
    }

    @Override
    public boolean delete(Categories enity) {
        return super.delete(enity);
    }
}
