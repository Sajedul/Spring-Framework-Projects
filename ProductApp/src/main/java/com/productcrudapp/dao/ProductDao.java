package com.productcrudapp.dao;

import com.productcrudapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component

public class ProductDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Transactional
    public void createProduct(Product product){
        this.hibernateTemplate.saveOrUpdate(product);
    }
    //get all product
    public List<Product> getProducts(){
       List<Product> products= this.hibernateTemplate.loadAll(Product.class);
       return products;
    }
    //get single product
    public Product getProduct(Integer pid){
        return this.hibernateTemplate.get(Product.class,pid);
    }
    //delete Product
    @Transactional
    public void deleteProduct(Integer pid){
       Product p = this.hibernateTemplate.get(Product.class,pid);
       this.hibernateTemplate.delete(p);
    }
}
