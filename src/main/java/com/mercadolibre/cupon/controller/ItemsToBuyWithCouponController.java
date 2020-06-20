package com.mercadolibre.cupon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsToBuyWithCouponController {

    @GetMapping("/healted")
    public ResponseEntity<String> healtCheck(){

        return new ResponseEntity<String>("ok",HttpStatus.OK);


    }
    
}