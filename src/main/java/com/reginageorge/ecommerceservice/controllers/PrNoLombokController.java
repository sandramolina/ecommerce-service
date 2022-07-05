package com.reginageorge.ecommerceservice.controllers;

import com.reginageorge.ecommerceservice.models.PrNoLombok;
import com.reginageorge.ecommerceservice.models.Product;
import com.reginageorge.ecommerceservice.repositories.PrNoLombokRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrNoLombokController {
    @Autowired
    PrNoLombokRepository prNoLombokRepository;

    @GetMapping(value = "PrNoLombok")
    public ResponseEntity<List<PrNoLombok>> getAllPrNoLombok(){
        return new ResponseEntity<>(prNoLombokRepository.findAll(), HttpStatus.OK);
    }
}
