package com.lazMalling.product.controller;

import com.lazMalling.product.model.Product;
import com.lazMalling.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/products")
    public @ResponseBody String postProduct(@RequestParam String productName,
                                            @RequestParam String productDescription,
                                            @RequestParam long productPrice,
                                            @RequestParam String productCategory,
                                            @RequestParam long userId){
        return productService.postProduct(productName,productDescription,productPrice,productCategory,userId);
    }
    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return  productService.getAllProduct();
    }
    @GetMapping("/products/{productId}")
    public Optional<Product> getProductById(@PathVariable long productId){
        return productService.getProductById(productId);
    }
    @PutMapping("/product/{productId}")
    public  Product updateProductById(@PathVariable long productId,Product product){
        return  productService.updateProductById(productId,product);
    }

    @DeleteMapping("/product/{productId}")
    public void deleteUserById(@PathVariable long productId){
        productService.deleteProductById(productId);
    }




}
