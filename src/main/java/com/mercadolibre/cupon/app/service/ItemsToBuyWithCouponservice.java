package com.mercadolibre.cupon.app.service;

import java.util.List;
import java.util.Map;

import com.mercadolibre.cupon.aplication.CalculateItems;
import com.mercadolibre.cupon.aplication.FillItems;
import com.mercadolibre.cupon.app.DTO.ItemsBuyRequestDto;
import com.mercadolibre.cupon.app.DTO.ItemsBuyResponseDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ItemsToBuyWithCouponservice {


    private static final Logger LOGGER = LoggerFactory.getLogger(ItemsToBuyWithCouponservice.class);

    @Autowired
    FillItems fillItems;

    @Autowired
    CalculateItems calculateItems;

    @Cacheable(cacheNames="coupon")
    public ItemsBuyResponseDto cacheableMethod(ItemsBuyRequestDto Items) {

        LOGGER.info("GET ITEMS");
        
        Map<String,Float> itemsWithValues = fillItems.getValuesItem(Items.getItemIds());

        List<String> itemsToBuy = calculateItems.calculate(itemsWithValues, Items.getAmount());

        ItemsBuyResponseDto response = ItemsBuyResponseDto.CreateItemsBuyResponseDto(itemsWithValues, itemsToBuy);

        return response;
    }
    
    
}