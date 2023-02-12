package com.lazMalling.product.controller;

import com.lazMalling.product.model.Product;
import com.lazMalling.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private  ProductService productService;



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
    public @ResponseBody ResponseEntity<HttpStatus> postProduct(@RequestBody Product product){
        return productService.postProduct(product);
    }
    //--------------------------------get all product ------------------------------------------------
    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return  productService.getAllProduct();
    }
    //--------------------------------get all product by id ------------------------------------------------
    @GetMapping("/products/{productId}")
    public Optional<Product> getProductById(@PathVariable long productId){
        return productService.getProductById(productId);
    }
    //--------------------------------get all product by id ------------------------------------------------
    @GetMapping("/getAllProductByUserId/{userId}")
    public  List<Product> getAllProductByUserId(@PathVariable long userId){
        return  productService.getAllProductByUserId(userId);
    }
    //--------------------------------update product by id ------------------------------------------------
    @PutMapping("/product/{productId}")
    public  ResponseEntity<HttpStatus>   updateProductById(@PathVariable long productId,@RequestBody Product product){
        return  productService.updateProductById(productId,product);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable long productId){

        return productService.deleteProductById(productId);
    }




}
