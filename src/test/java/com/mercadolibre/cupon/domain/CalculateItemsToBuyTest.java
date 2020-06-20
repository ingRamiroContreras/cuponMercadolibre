
package com.mercadolibre.cupon.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class CalculateItemsToBuyTest {

    @Test
    public void calculateTest() {

        /**
         * SetUp Test
         */

        Map<String, Float> items = new HashMap<>();
        items.put("MLA1", 10F);
        items.put("MLA2", 10F);
        items.put("MLA3", 10F);
        items.put("MLA4", 10F);
        items.put("MLA5", 10F);

        Float coupon = 500F;

        List<String> expected = Arrays.asList("MLA1", "MLA2", "MLA4", "MLA5");

        /**
         * Excecute Test
         */

        CalculateItemsToBuy calculateItemsToBuy = new CalculateItemsToBuy();
        List<String> result = calculateItemsToBuy.calculate(items, coupon);

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

        CalculateItemsToBuy calculateItemsToBuy = new CalculateItemsToBuy();
        List<String> result = calculateItemsToBuy.calculate(items, coupon);
        
        /**
         * Validate Test
         */

        assertTrue(result.isEmpty());

    }

}