package com.m2m.shopping.Service;

import com.m2m.shopping.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(Product Product);
    Product create(Product Product);
    Product findById(Integer id);
    boolean delete(Product Product);

    List<Product> findAll();

    List<Product> findToPage( Boolean existActive, int pageNumber, int pageSize);

    List<Product> findPageParam( Boolean existActive, int pageNumber, int pageSize, String title, Integer idCategories);

    List<Product> findPageParam( Boolean existActive, int pageNumber, int pageSize, Integer idCategories);

    List<Product> findPageParam( Boolean existActive, int pageNumber, int pageSize, String title);

    List<Product> findProductBetween(Double min , Double max);

    List<Product> findProductBetweenPage(Double min , Double max, int page, int maxPage);
    List<Product> findAllSortPriceDesc(int page, int maxPage);

    List<Product> findAllSortPriceAsc(int page, int maxPage);

    List<Product> findAllSortDate(int page, int maxPage);

    List<Product> findAllMemory(int page, int maxPage,Integer GB);
}
