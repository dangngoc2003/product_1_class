package com.example.product1.service;

import com.example.product1.model.Product;
import com.example.product1.repository.ICrudProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService   {
    @Autowired
    public ICrudProduct iCrudProduct;
    public Page<Product> findAll(Pageable pageable){
        return iCrudProduct.findAll(pageable);
    }
    public Product findOne( Long id){
        return iCrudProduct.findById(id).orElse(null);
    }
    public Product save(Product product){
     return    iCrudProduct.save(product);
    }
    public void delete(Long id){
        iCrudProduct.deleteById(id);
    }
    public Page<Product> findName(String name,Pageable pageable){
        return iCrudProduct.findName("%"+name+"%",pageable);
    }
}
