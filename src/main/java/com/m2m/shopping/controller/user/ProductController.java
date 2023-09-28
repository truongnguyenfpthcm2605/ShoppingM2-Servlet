package com.m2m.shopping.controller.user;

import com.m2m.shopping.Service.CategoriesService;
import com.m2m.shopping.Service.GalleryService;
import com.m2m.shopping.Service.Impl.CategoriesServiceImpl;
import com.m2m.shopping.Service.Impl.GalleryServiceImpl;
import com.m2m.shopping.Service.Impl.ProductServiceImpl;
import com.m2m.shopping.Service.ProductService;
import com.m2m.shopping.entity.Categories;
import com.m2m.shopping.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/product","/detail"})
public class ProductController  extends HttpServlet {
    private static final Integer maxPage = 9;
     ProductService productService = new ProductServiceImpl();
     CategoriesService categoriesService = new CategoriesServiceImpl();
     GalleryService galleryService = new GalleryServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch(path){
            case "/product":
                doGetProduct(req, resp);
                break;
            case "/detail":
                doDetail(req, resp);
                break;
        }
    }

    protected void doGetProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pagenumber = req.getParameter("page");
        String idCategory = req.getParameter("category");
        String title = req.getParameter("search");
        String sort = req.getParameter("sort");
        String memory = req.getParameter("memory");
        String minPrice = req.getParameter("minPrice");
        String maxPrice = req.getParameter("maxPrice");
        List<Product> products;
        List<Categories> categories = categoriesService.findAll();
        req.setAttribute("categories",categories);
        products = productService.findAll();
        req.setAttribute("total", products.size());
        int maxpage = (int)Math.ceil(products.size()/(double)maxPage);

        if(pagenumber !=null) {
            products = productService.findToPage(true, Integer.parseInt(pagenumber), maxPage);
        }else{
            if(idCategory!=null){
                products = productService.findPageParam(true,1,maxPage,Integer.valueOf(idCategory));
            }
            else if (title!=null) {
                products = productService.findPageParam(true,1, maxPage, title);
                req.setAttribute("search", title);
            }
            else if(sort!=null){
                products = getSort(Integer.parseInt(sort),1,maxPage);
                req.setAttribute("sort",Integer.parseInt(sort));
            }
            else if(memory!=null){
                products = productService.findAllMemory(1,maxPage,Integer.parseInt(memory));
            }
            else if(minPrice!=null && maxPrice!=null){
                Double min = Double.parseDouble(minPrice.substring(1,minPrice.length()));
                Double max = Double.parseDouble(maxPrice.substring(1,maxPrice.length()));
                products = productService.findProductBetweenPage(min,max,1,maxPage);
            }
            else{
                products = productService.findToPage(true, 1,maxPage);
            }
        }
        req.setAttribute("maxpage", maxpage);
        req.setAttribute("curentpage", pagenumber);
        req.setAttribute("products",products);
        req.getRequestDispatcher("/views/user/product.jsp").forward(req, resp);
    }

    protected void doDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Product product = productService.findById(id);
        product.setViews(product.getViews()+1);
        productService.save(product);
        String[] images = galleryService.findByIdProduct(id).getThumbnail().split("-");
        List<Product> products = productService.findProductBetween(product.getDiscount()-2000000, product.getDiscount()+2000000);
        req.setAttribute("products",products);
        req.setAttribute("images", images);
        req.setAttribute("p", product);
        req.getRequestDispatcher("/views/user/detail.jsp").forward(req, resp);
    }

    private List<Product> getSort(Integer sort, int page, int maxPage){
        return switch (sort){
            case 0 -> productService.findAllSortDate(page,maxPage);
            case 1 -> productService.findAllSortPriceAsc(page,maxPage);
            case 2 -> productService.findAllSortPriceDesc(page,maxPage);
            default -> throw new IllegalStateException("Unexpected value: " + sort);
        };
    }


}
