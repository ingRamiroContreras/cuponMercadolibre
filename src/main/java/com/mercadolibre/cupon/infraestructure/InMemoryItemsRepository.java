package com.mercadolibre.cupon.infraestructure;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import com.mercadolibre.cupon.domain.ItemsService;

public class InMemoryItemsRepository implements ItemsService {

    @Override
    public Map<String, Float> getValuesItem(List<String> itemsList) {

        Map<String, Float> result = itemsList.stream().collect(Collectors.toMap( i -> i, i -> generateFloarValues()));

        return result;

    }

    private Float  generateFloarValues() {
        Float leftLimit = 1F;
        Float rightLimit = 100000F;
        return  roundFloat(leftLimit + new Random().nextFloat() * (rightLimit - leftLimit));
 
    }

    private float roundFloat(float f) {
        int places = 2;
	    BigDecimal bigDecimal = new BigDecimal(Float.toString(f));
	    bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
	    return bigDecimal.floatValue();
	}
}

    