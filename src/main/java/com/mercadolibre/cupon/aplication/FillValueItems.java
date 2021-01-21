package com.mercadolibre.cupon.aplication;

import java.util.List;
import java.util.Map;

import com.mercadolibre.cupon.domain.ItemsService;

public class FillValueItems implements FillItems{

    ItemsService repository;
    
    private FillValueItems(ItemsService repository){

        this.repository = repository;

    }

    public static FillValueItems createFillValueItems(ItemsService repository){

        return new FillValueItems(repository);

    }

    @Override
    public Map<String,Float> getValuesItem(List<String> itemsList){

        return this.repository.getValuesItem(itemsList);
        
    }
    
}