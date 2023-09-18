package com.m2m.shopping.Service.Impl;

import com.m2m.shopping.Service.GalleryService;
import com.m2m.shopping.entity.Gallery;
import com.m2m.shopping.repository.JpaRepository;

import java.util.List;

public class GalleryServiceImpl extends JpaRepository<Gallery> implements GalleryService {
    @Override
    public Gallery findById(Integer id) {
        return super.findByid(Gallery.class,id);
    }

    @Override
    public List<Gallery> findAll() {
        return super.findAll(Gallery.class,false);
    }

    @Override
    public Gallery findByIdProduct(Integer id) {
        String sql = "select o from Gallery o where o.product.id = ?0";
        return  super.findMany(Gallery.class, sql, id).get(0);
    }

    @Override
    public Gallery create(Gallery enity) {
        return super.create(enity);
    }

    @Override
    public Gallery save(Gallery enity) {
        return super.save(enity);
    }

    @Override
    public boolean delete(Gallery enity) {
        return super.delete(enity);
    }
}
