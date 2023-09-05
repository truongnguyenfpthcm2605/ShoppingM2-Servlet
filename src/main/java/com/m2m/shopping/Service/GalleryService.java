package com.m2m.shopping.Service;

import com.m2m.shopping.entity.Gallery;

import java.util.List;

public interface GalleryService {
    Gallery save(Gallery gallery);
    Gallery create(Gallery gallery);
    Gallery findById(Integer id);
    boolean delete(Gallery gallery);

    List<Gallery> findAll();

}
