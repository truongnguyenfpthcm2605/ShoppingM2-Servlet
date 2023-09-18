package com.m2m.shopping.Service;

import com.m2m.shopping.entity.Authorities;

import java.util.List;

public interface AuthoritiesService {


    Authorities create(Authorities authorities);
    Authorities save(Authorities authorities);

    Authorities findById(Integer id);

    boolean deleteById(Authorities authorities);

    List<Authorities> findAll();

}
