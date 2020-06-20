package com.mercadolibre.cupon.domain;

public class CouponValueEcxeption extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CouponValueEcxeption() {
        super("invalid coupon value");
    }
    
}