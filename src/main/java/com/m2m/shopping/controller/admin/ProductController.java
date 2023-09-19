package com.m2m.shopping.controller.admin;

import com.m2m.shopping.Service.CategoriesService;
import com.m2m.shopping.Service.Impl.CategoryServiceImpl;
import com.m2m.shopping.Service.Impl.ProductServiceImpl;
import com.m2m.shopping.Service.ProductService;
import com.m2m.shopping.entity.Categories;
import com.m2m.shopping.entity.Product;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@MultipartConfig
@WebServlet(urlPatterns = {"/admin/products"}, name = "ProductControllerOfAdmin")
public class ProductController extends HttpServlet {

    private static ProductService productService;
    private static CategoriesService categoriesService;

    @Override
    public void init() throws ServletException {
        super.init();
        productService = new ProductServiceImpl();
        categoriesService = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "view" -> doGetOverView(req, resp);
            case "delete" -> doGetDelete(req, resp);
            case "add" -> doGetAdd(req, resp);
            case "edit" -> doGetEdit(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isEdit = req.getParameter("isEdit");
        switch (isEdit) {
            case "true" -> doPostEdit(req, resp);
            case "false" -> doPostAdd(req, resp);
        }
    }

    private void doGetOverView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/admin/products.jsp").forward(req, resp);
    }

    private void doGetDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idTemp = req.getParameter("id");
        Integer id = Integer.valueOf(idTemp);
        Product product = productService.findById(id);
        boolean isDeleted = productService.delete(product);
        System.out.println(isDeleted);
        resp.sendRedirect("/admin/products?action=view");
    }

    private void doGetAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("isEdit", "false");
        req.getRequestDispatcher("/views/admin/products_edit.jsp").forward(req, resp);
    }

    private void doGetEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idTemp = req.getParameter("id");
        Integer id = Integer.valueOf(idTemp);
        Product product = productService.findById(id);

        req.setAttribute("product", product);
        System.out.println(product.getCreateDate());
        req.setAttribute("isEdit", "true");
        req.getRequestDispatcher("/views/admin/products_edit.jsp").forward(req, resp);
    }

    private void doPostAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("yyyy-mm-dd");
            ConvertUtils.register(dtc, Date.class);

            Product product = new Product();
            product.setTitle(req.getParameter("title"));
            product.setPrice(Long.valueOf(req.getParameter("price")));
            product.setDiscount(Long.valueOf(req.getParameter("discount")));
            Categories categories = categoriesService.findById(Integer.valueOf(req.getParameter("categories")));
            product.setCategories(categories);
            product.setStockquantity(Integer.valueOf(req.getParameter("stockquantity")));
            product.setImg(req.getParameter("img"));
            product.setDescription(req.getParameter("description"));

            req.setAttribute("isEdit", "false");

            productService.save(product);

        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/admin/products?action=view");

    }

    private void doPostEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Product product = new Product();
            product.setId(Integer.valueOf(req.getParameter("id")));
            product.setTitle(req.getParameter("title"));
            product.setPrice(Long.valueOf(req.getParameter("price")));
            product.setDiscount(Long.valueOf(req.getParameter("discount")));
            Categories categories = categoriesService.findById(Integer.valueOf(req.getParameter("categories")));
            product.setCategories(categories);
            product.setStockquantity(Integer.valueOf(req.getParameter("stockquantity")));
            product.setImg(req.getParameter("img"));
            product.setDescription(req.getParameter("description"));

            req.setAttribute("isEdit", "false");

            productService.save(product);

        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/admin/products?action=view");
    }
}
