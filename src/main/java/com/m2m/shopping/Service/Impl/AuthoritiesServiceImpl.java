package com.m2m.shopping.Service.Impl;

import com.m2m.shopping.Service.AuthoritiesService;
import com.m2m.shopping.entity.Authorities;
import com.m2m.shopping.repository.JpaRepository;

import java.util.List;

public class AuthoritiesServiceImpl  extends JpaRepository<Authorities> implements AuthoritiesService {
    @Override
    public Authorities findById(Integer id) {
        return super.findByid(Authorities.class, id);
    }

    @Override
    public boolean deleteById(Authorities authorities) {
        return super.delete(authorities);
    }

    @Override
    public List<Authorities> findAll() {
        return super.findAll(Authorities.class, false);
    }

    @Override
    public Authorities create(Authorities enity) {
        return super.create(enity);
    }

    @Override
    public Authorities save(Authorities enity) {
        return super.save(enity);
    }
}
