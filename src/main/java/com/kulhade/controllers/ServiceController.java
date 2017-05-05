package com.kulhade.controllers;

import com.kulhade.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vk250236 on 4/17/17.
 */
@Controller
@RequestMapping("/services")
public class ServiceController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getProductView(){
        return new ModelAndView("productView", "prdt", new Product());
    }

    @RequestMapping(value = "/product",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody
    ResponseEntity<List<Product>> createProduct(@RequestBody  Product[] products) {
        return new ResponseEntity<List<Product>>(Arrays.asList(products), HttpStatus.OK);
    }

    @RequestMapping(value = "/products",method = RequestMethod.GET)
    public @ResponseBody
    List<Product> getProductList() {
        List<Product> products = new ArrayList<>(5);
        Product product = new Product();
        product.setProduct_Name("One Product");
        product.setDescripction("Essentials");
        product.setId(1);
        product.setPrice("100.00");
        products.add(product);
        return products;
    }
}
