package com.vince.crud.example.service;


import com.vince.crud.example.entity.Product;
import com.vince.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> productList){
        return productRepository.saveAll(productList);
    }

    // GET METHODS
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    // customize

    public Optional<Product> getProductByName(String name){
        return productRepository.findByName(name);
    }

    //delete
    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "pro" +
                "duct removed" + id;
    }

    // update product
    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);
    }
}
