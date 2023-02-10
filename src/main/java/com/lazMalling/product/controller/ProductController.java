package com.lazMalling.product.controller;

import com.lazMalling.product.model.Product;
import com.lazMalling.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController (ProductService productService){
        this.productService=productService;
    }

    //--------------------------------get all client user-----------------------------------------------
    @GetMapping("/getAllClientUser")
    public  List<Object> getAllClientUser(){
        return Arrays.asList(productService.getAllClientUser());
    }
    //--------------------------------get user role-----------------------------------------------------
    @GetMapping("/getClientUserRole/{userId}")
    public String getClientUserRole(@PathVariable long userId){
        return productService.getClientUserByRole(userId);
    }
    //--------------------------------post new product ------------------------------------------------
    @PostMapping("/products")
    public @ResponseBody String postProduct(@RequestBody Product product){
        return productService.postProduct(product);
    }
//    @PostMapping("/products")
//    public @ResponseBody Product postProduct(@RequestBody Product product){
//        return productService.postProduct(product);
//    }
    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return  productService.getAllProduct();
    }
    @GetMapping("/products/{productId}")
    public Optional<Product> getProductById(@PathVariable long productId){
        return productService.getProductById(productId);
    }
    @PutMapping("/product/{productId}")
    public  String updateProductById(@PathVariable long productId,Product product){
        return  productService.updateProductById(productId,product);
    }

    @DeleteMapping("/product/{productId}")
    public void deleteUserById(@PathVariable long productId){
        productService.deleteProductById(productId);
    }




}
