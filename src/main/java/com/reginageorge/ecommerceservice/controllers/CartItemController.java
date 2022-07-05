package com.reginageorge.ecommerceservice.controllers;

import com.reginageorge.ecommerceservice.models.CartItem;
import com.reginageorge.ecommerceservice.repositories.CartItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartItemController {

    @Autowired
    CartItemsRepository cartItemsRepository;

    @GetMapping(value = "/cart")
    public ResponseEntity<List<CartItem>> getAllCarts(){
        return new ResponseEntity<>(cartItemsRepository.findAll(), HttpStatus.OK);
    }
}
