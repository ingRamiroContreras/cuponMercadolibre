package com.mercadolibre.cupon.aplication;

import java.util.List;
import java.util.Map;

public interface CalculateItems {

    public List<String> calculate(Map<String, Float> items, Float coupon);
    
}