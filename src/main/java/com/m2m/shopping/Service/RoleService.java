package com.m2m.shopping.Service;

import com.m2m.shopping.entity.Roles;

import java.util.List;

public interface RoleService {

    Roles save(Roles Roles);
    Roles create(Roles Roles);
    Roles findById(Integer id);
    boolean delete(Roles Roles);

    List<Roles> findAll();
}
