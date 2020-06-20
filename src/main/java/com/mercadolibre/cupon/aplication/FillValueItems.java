package com.mercadolibre.cupon.aplication;

import java.util.List;
import java.util.Map;

import com.mercadolibre.cupon.domain.ItemsRepository;

public class FillValueItems {

    ItemsRepository repository;
    
    FillValueItems(ItemsRepository repository){

        this.repository = repository;

    }

    Map<String,Float> getValuesItem(List<String> itemsList){

        return this.repository.getValuesItem(itemsList);
        
    }
    
}