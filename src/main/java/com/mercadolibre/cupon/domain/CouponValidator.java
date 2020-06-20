package com.mercadolibre.cupon.domain;

import java.util.Map;
import java.util.StringTokenizer;

public class CouponValidator {

    Map<String, Float> items;
    Float coupon;

    CouponValidator(Map<String, Float> items,Float coupon){
        this.items = items;
        this.coupon = coupon;
    }

    public static CouponValidator createCouponvalidator(Map<String, Float> items,Float coupon){
        return new CouponValidator(items,coupon);
    }


    public boolean CouponGreaterThanItems() {

        Float sumValuesItemns = 0.F;

        for (Map.Entry<String, Float> entry : items.entrySet()) {
            sumValuesItemns = sumValuesItemns + entry.getValue();
        }

        return coupon > sumValuesItemns ? true : false;
    }

    public boolean failValueCoupon() {

        String digits = String.valueOf(coupon);
        StringTokenizer tokens = new StringTokenizer(digits, ".");

        String numbers = tokens.nextToken();
        String decimals = tokens.nextToken();
        
        return (decimals.length() > 2);

    }

    
}