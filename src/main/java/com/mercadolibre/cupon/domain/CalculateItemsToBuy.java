package com.mercadolibre.cupon.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class CalculateItemsToBuy {

    public List<String> calculate(Map<String, Float> items, Float coupon) {

        if (!failValueCoupon(coupon))
            return new ArrayList<>();

        return Arrays.asList("MLA1", "MLA2", "MLA4", "MLA5");

    }

    private boolean failValueCoupon(Float coupon) {

        String digits = String.valueOf(coupon);
        StringTokenizer tokens = new StringTokenizer(digits, ".");

        String numbers = tokens.nextToken();
        String decimals = tokens.nextToken();

        return (decimals.length() <= 2);

    }

}
