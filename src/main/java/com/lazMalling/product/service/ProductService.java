package com.lazMalling.product.service;

import com.lazMalling.product.dto.UserDto;
import com.lazMalling.product.model.Product;
import com.lazMalling.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestTemplate restTemplate;


    //-------------------------------------get all client user----------------------------------------------
    public List<Object> getAllClientUser(){
        String url="http://localhost:8081/api/users";
        Object[] users=restTemplate.getForObject(url,Object[].class);
        return Arrays.asList(users);
    }

    //--------------------------------------get the user role---------------------------------------------------
    public  String getClientUserByRole(long userId){
        UserDto userDto=restTemplate.getForObject("http://localhost:8081/api/users/"+userId,UserDto.class);
        return userDto.getRole();
    }
    //-----------------------------------------get the user id--------------------------------------------------
    public  long getClientUserById(long userId){
        UserDto userDto=restTemplate.getForObject("http://localhost:8081/api/users/"+userId,UserDto.class);
        return  userDto.getUserId();
    }

    //-----------------------------------------create new product-----------------------------------------------
//    public Product postProduct(Product product){
//        Product product1=new Product();
//        String userRole=getClientUserByRole(product.getUserId());
//        String regex="(?i)seller";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher match= pattern.matcher(userRole);
//        if(match.matches()){
//             product1=productRepository.save(product);
//        }
//        return product1;
//    }

    public String postProduct(Product product){
        String userRole=getClientUserByRole(product.getUserId());
        String regex="(?i)seller";
        Pattern pattern = Pattern.compile(regex);
        Matcher match= pattern.matcher(userRole);
        if(match.matches()){
            productRepository.save(product);
            return "Product successfully added";
        }else {
            return "Product Not successfully added";
        }
    }
    //-------------------------------------------get all the product---------------------------------------------
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    //-------------------------------------get all the product using product id-----------------------------------
    public Optional<Product> getProductById(long productId){
        return productRepository.findById(productId);
    }

    //------------------------------------------update product using product id-----------------------------------
    public String updateProductById( long productId,Product product){

        String userRole=getClientUserByRole(product.getUserId());
        String regex="(?i)seller";
        Pattern pattern = Pattern.compile(regex);
        Matcher match= pattern.matcher(userRole);
        if(match.matches()){
            product.setProductId(productId);
            productRepository.save(product);
            return "Product successfully added";

        }else {
            return "Product Not successfully added";
        }
    }

    //------------------------------------------delete product using product id------------------------------------
    public void deleteProductById(long productId){
        productRepository.deleteById(productId);
    }
}
