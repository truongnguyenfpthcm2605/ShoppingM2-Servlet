package com.m2m.shopping.Service;

import com.m2m.shopping.entity.Categories;

import java.util.List;

public interface CategoriesService {

    Categories save(Categories categories);
    Categories create(Categories categories);

    Categories findById(Integer id);

    boolean delete(Categories categories);

    List<Categories> findAll();

}
