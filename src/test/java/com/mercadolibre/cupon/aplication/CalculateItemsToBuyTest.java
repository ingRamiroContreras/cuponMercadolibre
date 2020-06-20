
package com.mercadolibre.cupon.aplication;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mercadolibre.cupon.domain.PurchaseItemsCouponMercadoLibre;

import org.junit.jupiter.api.Test;

public class CalculateItemsToBuyTest {

    @Test
    public void calculateTest() {

        /**
         * SetUp Test
         */

        Map<String, Float> items = new HashMap<>();
        items.put("MLA1", 100F);
        items.put("MLA2", 210F);
        items.put("MLA3", 260F);
        items.put("MLA4", 80F);
        items.put("MLA5", 90F);

        Float coupon = 500F;

        List<String> expected = Arrays.asList("MLA1", "MLA2", "MLA4", "MLA5");

        /**
         * Excecute Test
         */
        PurchaseItemsCouponMercadoLibre  purchase = new PurchaseItemsCouponMercadoLibre();
        CalculateItemsToBuy calculateItemsToBuy = new CalculateItemsToBuy(purchase);
        List<String> result = calculateItemsToBuy.calculate(items, coupon);
        Collections.sort(result);

        /**
         * Validate Test
         */

        assertThat(result, is(expected));

    }

    @Test
    public void validateValuesCouponWith2DecimalsTest() {

        /**
         * SetUp Test
         */

        Map<String, Float> items = new HashMap<>();
        items.put("MLA1", 10F);
        items.put("MLA2", 10F);
        items.put("MLA3", 10F);
        items.put("MLA4", 10F);
        items.put("MLA5", 10F);

        Float coupon = 500.016F;

        /**
         * Excecute Test
         */
        PurchaseItemsCouponMercadoLibre  purchase = new PurchaseItemsCouponMercadoLibre();
        CalculateItemsToBuy calculateItemsToBuy = new CalculateItemsToBuy(purchase);
        List<String> result = calculateItemsToBuy.calculate(items, coupon);
        
        /**
         * Validate Test
         */

        assertTrue(result.isEmpty());

    }


    @Test
    public void validateValueItemsMinorThatValueCoupon() {

        Map<String, Float> items = new HashMap<>();
        items.put("MLA1", 100F);
        items.put("MLA2", 210F);
        items.put("MLA3", 260F);
        items.put("MLA4", 80F);

        Float coupon = 1000F;

        List<String> expected = Arrays.asList("MLA1", "MLA2", "MLA3", "MLA4");

        /**
         * Excecute Test
         */
        PurchaseItemsCouponMercadoLibre  purchase = new PurchaseItemsCouponMercadoLibre();
        CalculateItemsToBuy calculateItemsToBuy = new CalculateItemsToBuy(purchase);
        List<String> result = calculateItemsToBuy.calculate(items, coupon);
        Collections.sort(result);

        /**
         * Validate Test
         */

        assertThat(result, is(expected));



    }

    @Test
    public void validateValueCouponIsLessThatValueItems() {

        Map<String, Float> items = new HashMap<>();
        items.put("MLA1", 100F);
        items.put("MLA2", 210F);
        items.put("MLA3", 260F);
        items.put("MLA4", 80F);

        Float coupon = 10F;
        PurchaseItemsCouponMercadoLibre  purchase = new PurchaseItemsCouponMercadoLibre();
        CalculateItemsToBuy calculateItemsToBuy = new CalculateItemsToBuy(purchase);

        /**
         * Excecute Test
         */
        List<String> result = calculateItemsToBuy.calculate(items, coupon);
        
        /**
         * Validate Test
         */

        assertTrue(result.isEmpty());

    }


}