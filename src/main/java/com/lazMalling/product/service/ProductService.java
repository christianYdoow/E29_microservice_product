package com.lazMalling.product.service;

import com.lazMalling.product.model.Product;
import com.lazMalling.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    public String postProduct(String productName,String productDescription,long productPrice,String productCategory,long userId){
        Product product=new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setProductPrice(productPrice);
        product.setProductCategory(productCategory);
        product.setUserId(userId);

        System.out.println(productRepository.save(product));
        return "saved";
    }
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(long productId){
        return productRepository.findById(productId);
    }
    public Product updateProductById(long productId,Product product){
        product.setProductId(productId);
        return productRepository.save(product);
    }
    public void deleteProductById(long productId){
        productRepository.deleteById(productId);
    }
}
