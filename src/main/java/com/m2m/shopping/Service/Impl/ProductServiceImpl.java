package com.m2m.shopping.Service.Impl;

import com.m2m.shopping.Service.ProductService;
import com.m2m.shopping.entity.Product;
import com.m2m.shopping.repository.JpaRepository;

import java.util.List;

public class ProductServiceImpl  extends JpaRepository<Product> implements ProductService {
    @Override
    public Product findById(Integer id) {
        return super.findByid(Product.class,id);
    }

    @Override
    public List<Product> findAll() {
        return super.findAll(Product.class, true);
    }
    @Override
    public Product create(Product enity) {
        return super.create(enity);
    }

    @Override
    public Product save(Product enity) {
        return super.save(enity);
    }

    @Override
    public boolean delete(Product enity) {
        return super.delete(enity);
    }

    @Override
    public List<Product> findToPage(Boolean existActive, int pageNumber, int pageSize) {
        return super.findToPage(Product.class,existActive,pageNumber,pageSize);
    }

    @Override
    public List<Product> findPageParam(Boolean existActive, int pageNumber, int pageSize, String title, Integer idCategories) {
        String sql = "select o from Product o where o.isActive = ?0 and  o.title like ?1 and o.categories.id = ?2";
        return super.findManyPage(Product.class, sql, pageNumber, pageSize,existActive, "%"+title+"%", idCategories );
    }

    @Override
    public List<Product> findPageParam(Boolean existActive, int pageNumber, int pageSize, Integer idCategories) {
        String sql = "select o from Product o where o.isActive = ?0 and  o.categories.id = ?1 ";
        return super.findManyPage(Product.class,sql,pageNumber,pageSize,existActive, idCategories );
    }

    @Override
    public List<Product> findPageParam(Boolean existActive, int pageNumber, int pageSize, String title) {
        String sql = "select o from Product o where o.isActive = ?0 and o.title like ?1 or o.categories.title like ?2";
        return super.findManyPage(Product.class,sql,pageNumber,pageSize,existActive,"%"+title+"%","%"+title+"%" );
    }

    @Override
    public List<Product> findProductBetweenDiscount(Double min, Double max) {
        String sql = "select o from Product o where o.discount between ?0 and ?1";
        List<Product> results = super.findMany(Product.class, sql, min, max);
        if (results.size() <= 4) {
            return results;
        }
        return results.subList(0, 4);
    }

    @Override
    public List<Product> findProductBetweenPage(Double min, Double max, int page, int maxPage) {
        String sql = "select o from Product o where o.discount between ?0 and ?1";
        return  super.findManyPage(Product.class,sql, page,maxPage,min,max);
    }

    @Override
    public List<Product> findAllSortPriceDesc(int page, int maxPage) {
        String sql = "select o from Product o ORDER BY o.price DESC ";
        return super.findManyPage(Product.class,sql,page,maxPage);
    }

    @Override
    public List<Product> findAllSortPriceAsc(int page, int maxPage) {
        String sql = "select o from Product o ORDER BY o.price ASC ";
        return super.findManyPage(Product.class,sql,page,maxPage);
    }

    @Override
    public List<Product> findAllSortDate(int page, int maxPage) {
        String sql = "select o from Product o ORDER BY o.createDate DESC ";
        return super.findManyPage(Product.class,sql,page,maxPage);
    }

    @Override
    public List<Product> findAllMemory(int page, int maxPage ,Integer GB) {
        String sql = "select o from Product o where o.ram = ?0 ORDER BY o.price ASC ";
        return super.findManyPage(Product.class, sql,page,maxPage,GB );
    }

    @Override
    public List<Product> findByCategory(int categoryId) {
        String sql = "Select o from Product o where o.categories.id = ?0 and o.isActive = 1";
        return super.findMany(Product.class,sql, categoryId);
    }

    @Override
    public List<Product> findTop10() {
        String sql = "SELECT p FROM Product p WHERE p.isActive = 1 ORDER BY p.views DESC";
        return super.findMany(Product.class, sql).subList(0, 10);
    }



}
