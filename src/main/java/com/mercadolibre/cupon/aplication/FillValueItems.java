package com.mercadolibre.cupon.aplication;

import java.util.List;
import java.util.Map;

import com.mercadolibre.cupon.domain.ItemsRepository;

public class FillValueItems implements FillItems{

    ItemsRepository repository;
    
    FillValueItems(ItemsRepository repository){

        this.repository = repository;

    }

    @Override
    public Map<String,Float> getValuesItem(List<String> itemsList){

        return this.repository.getValuesItem(itemsList);
        
    }
    
}