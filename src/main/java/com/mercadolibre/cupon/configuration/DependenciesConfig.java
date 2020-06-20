package com.mercadolibre.cupon.configuration;

import com.mercadolibre.cupon.aplication.CalculateItems;
import com.mercadolibre.cupon.aplication.CalculateItemsToBuy;
import com.mercadolibre.cupon.domain.PurchaseItems;
import com.mercadolibre.cupon.domain.PurchaseItemsCouponMercadoLibre;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependenciesConfig {
    
    
    @Bean
    public CalculateItems getCalculateItems(){
        
        PurchaseItems purchase = new PurchaseItemsCouponMercadoLibre();
        CalculateItems calculateItemsToBuy = CalculateItemsToBuy.createCalculateItemsToBuy(purchase);

        return calculateItemsToBuy;
    }

}