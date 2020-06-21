package com.mercadolibre.cupon.app.configuration;

import com.mercadolibre.cupon.aplication.CalculateItems;
import com.mercadolibre.cupon.aplication.CalculateItemsToBuy;
import com.mercadolibre.cupon.aplication.FillItems;
import com.mercadolibre.cupon.aplication.FillValueItems;
import com.mercadolibre.cupon.domain.ItemsRepository;
import com.mercadolibre.cupon.domain.PurchaseItems;
import com.mercadolibre.cupon.domain.PurchaseItemsCouponMercadoLibre;
import com.mercadolibre.cupon.infraestructure.MercadoLibreItemsRepository;

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

    @Bean
    public FillItems getFillItems(){
        
        ItemsRepository mercalodibreItemsRepository = new MercadoLibreItemsRepository();
        FillItems fillValueItems =  FillValueItems.createFillValueItems(mercalodibreItemsRepository);
        
        return fillValueItems;
    }

}