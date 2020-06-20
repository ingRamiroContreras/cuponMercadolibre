package com.mercadolibre.cupon.controller;

import com.mercadolibre.cupon.DTO.ItemsBuyDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsToBuyWithCouponController {

    @GetMapping("/healted")
    public ResponseEntity<String> healtCheck(){

        return new ResponseEntity<String>("ok",HttpStatus.OK);


    }

    @PostMapping("/coupon")
    public  ResponseEntity<ItemsBuyDto> getItemsToBuyCoupon(@RequestBody ItemsBuyDto Items){

        return new ResponseEntity<ItemsBuyDto>(new ItemsBuyDto(),HttpStatus.OK);

    }
    
}