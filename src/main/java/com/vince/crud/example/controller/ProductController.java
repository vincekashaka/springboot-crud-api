package com.vince.crud.example.controller;

import com.vince.crud.example.entity.Product;
import com.vince.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@PathVariable Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(List<Product> productList){
        return productService.saveProducts(productList);
    }

    // get api
    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("/product/{id}")
    public Optional<Product> findProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @GetMapping("/products/{name}")
    public Optional<Product> findProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    // put

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    // delete
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }

}
