package com.mercadolibre.cupon.domain;

import java.util.List;
import java.util.Map;

public interface ItemsRepository {

    public Map<String,Float> getValuesItem(List<String> itemsList);
    
}