package com.mercadolibre.cupon.app.controller;

import com.mercadolibre.cupon.app.DTO.ItemsBuyRequestDto;
import com.mercadolibre.cupon.app.DTO.ItemsBuyResponseDto;
import com.mercadolibre.cupon.app.service.ItemsToBuyWithCouponservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsToBuyWithCouponPostController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemsToBuyWithCouponPostController.class);


    @Autowired
    ItemsToBuyWithCouponservice itemsToBuyWithCouponservice;

 
    @PostMapping("/coupon")
    public  ResponseEntity<ItemsBuyResponseDto> invoke(@RequestBody ItemsBuyRequestDto Items){

        LOGGER.info("GET ITEMS CONTROLLER");

        ItemsBuyResponseDto response = itemsToBuyWithCouponservice.cacheableMethod(Items);

        if (response.getItemIds().isEmpty())
            return new ResponseEntity<ItemsBuyResponseDto>(response,HttpStatus.NOT_FOUND);    

        return new ResponseEntity<ItemsBuyResponseDto>(response,HttpStatus.OK);

        
    }

   
}