package com.mercadolibre.cupon.domain;

import java.util.List;

public interface PurchaseItems {
    
    public List<String> excecute(Float valueCoupon, Item[] items);

}