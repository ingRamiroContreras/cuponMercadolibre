package com.mercadolibre.cupon.controller;

import java.util.List;
import java.util.Map;

import com.mercadolibre.cupon.DTO.ItemsBuyRequestDto;
import com.mercadolibre.cupon.DTO.ItemsBuyResponseDto;
import com.mercadolibre.cupon.aplication.CalculateItems;
import com.mercadolibre.cupon.aplication.FillItems;
import com.mercadolibre.cupon.service.ItemsToBuyWithCouponservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsToBuyWithCouponPostController {

    @Autowired
    ItemsToBuyWithCouponservice itemsToBuyWithCouponservice;

 
    @PostMapping("/coupon")
    public  ResponseEntity<ItemsBuyResponseDto> invoke(@RequestBody ItemsBuyRequestDto Items){

        ItemsBuyResponseDto response = itemsToBuyWithCouponservice.cacheableMethod(Items);

        if (response.getItemIds().isEmpty())
            return new ResponseEntity<ItemsBuyResponseDto>(response,HttpStatus.NOT_FOUND);    

        return new ResponseEntity<ItemsBuyResponseDto>(response,HttpStatus.OK);

        
    }

   
}