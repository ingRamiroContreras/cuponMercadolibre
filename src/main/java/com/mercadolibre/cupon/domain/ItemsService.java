package com.mercadolibre.cupon.domain;

import java.util.List;
import java.util.Map;

public interface ItemsService {

    public Map<String,Float> getValuesItem(List<String> itemsList);
    
}