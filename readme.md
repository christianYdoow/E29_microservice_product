# Microservice for E-Commerce project

## Introduction

This document describes the design and implementation of microservices for an e-commerce project. The goal is to break down the project's functionalities and create individual microservices that follow the principles of microservice architecture

## Microservices

this is one of the microservices for this E-commerce project

## Product Service

The Product Service is responsible for managing the product catalog and handling the following functionalities:

## functionalities


- **postProduct** create new product
- **getAllProduct** show all the product information it can be used for administrative purpose also this will be used to display all available product in the e-commerce app
- **getProductById** show specific product .
- **updateProductById** update product details that match the user id these functionalities is exclusively for seller
- **deleteProductById** delete product that match the user id these functionalities is exclusively for seller

- **getClientUserByRole**  this function help to determine whether the user role is buyer or seller this function is vital because this determines what functionalities will be for the buyer and for the  seller
- **getAllProductByUserId** show all the product that is related   user (seller) id this functionalities can be used to show
  all the product created by the user (Seller)


This functionality is isolated from other services as it deals with product information, which is an important aspect of the e-commerce project and needs to be managed independently to ensure reliability and performance.