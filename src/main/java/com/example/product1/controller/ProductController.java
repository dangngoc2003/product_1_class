package com.example.product1.controller;

import com.example.product1.model.Product;
import com.example.product1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")

public class ProductController {
    @Autowired
    public ProductService productService;
    @GetMapping
    public ResponseEntity<Page<Product>> findAll(@PageableDefault Pageable pageable){
    return new ResponseEntity<>(productService.findAll(pageable), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Product> create(@RequestBody Product product){
    return new ResponseEntity<>(productService.save(product),HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product=productService.findOne(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product,@PathVariable Long id){
    productService.save(product);
    return new ResponseEntity<>(productService.findOne(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id){
    Product product=productService.findOne(id);
    productService.delete(id);
    return new ResponseEntity<>(product,HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<Page<Product>> searchByName(@PageableDefault(value = 3) @PathVariable String name,Pageable pageable){
        return new ResponseEntity<>(productService.findName(name,pageable),HttpStatus.OK);
    }
}
