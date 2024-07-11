package com.productcrudapp.controller;

import com.productcrudapp.dao.ProductDao;
import com.productcrudapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ProductDao productDao;
    @RequestMapping("/")
    public String home(Model m){
        List<Product> products = productDao.getProducts();
        m.addAttribute("products",products);
        return "index";
    }
    //show add product form
    @RequestMapping("/add-product")
    public String addProduct(Model m){
        m.addAttribute("title","Add Product");
        return "add_product_form";
    }

   /* @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
        System.out.println("Custom editor for Integer registered");
    }*/
    //Handle Add Product Form

    @RequestMapping(value ="/handle-product", method = RequestMethod.POST)
    public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request){
       /* if (product.getId() == null) {
            product.setId(generateNewProductId());
        }*/
        System.out.println(product);
        productDao.createProduct(product);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/");
        return redirectView;
    }
    @RequestMapping("/delete/{productId}")
    public RedirectView deleteProduct(@PathVariable("productId")Integer productId, HttpServletRequest request){
        this.productDao.deleteProduct(productId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/");
        return redirectView;
    }
    @RequestMapping("/update/{productId}")
    public String updateForm(@PathVariable("productId")Integer pid,Model model){
       Product product= this.productDao.getProduct(pid);
       model.addAttribute("product",product);
        return "update-form";
    }
    /*private Integer generateNewProductId() {
        // Logic to generate a new product id
        return 1; // Placeholder value, replace with actual logic
    }*/
}
