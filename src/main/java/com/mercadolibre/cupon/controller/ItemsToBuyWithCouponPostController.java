package com.mercadolibre.cupon.controller;

import java.util.List;
import java.util.Map;

import com.mercadolibre.cupon.DTO.ItemsBuyRequestDto;
import com.mercadolibre.cupon.DTO.ItemsBuyResponseDto;
import com.mercadolibre.cupon.aplication.CalculateItems;
import com.mercadolibre.cupon.aplication.FillItems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsToBuyWithCouponPostController {

    @Autowired
    FillItems fillItems;

    @Autowired
    CalculateItems calculateItems;


    @PostMapping("/coupon")
    public  ResponseEntity<ItemsBuyResponseDto> invoke(@RequestBody ItemsBuyRequestDto Items){

        Map<String,Float> itemsWithValues = fillItems.getValuesItem(Items.getItemIds());

        List<String> itemsToBuy = calculateItems.calculate(itemsWithValues, Items.getAmount());

        ItemsBuyResponseDto response = ItemsBuyResponseDto.CreateItemsBuyResponseDto(itemsWithValues, itemsToBuy);

        if (response.getItemIds().isEmpty())
            return new ResponseEntity<ItemsBuyResponseDto>(response,HttpStatus.NOT_FOUND);    

        return new ResponseEntity<ItemsBuyResponseDto>(response,HttpStatus.OK);

    }
    
}