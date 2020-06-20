package com.mercadolibre.cupon.aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.mercadolibre.cupon.domain.CouponValidator;
import com.mercadolibre.cupon.domain.Item;
import com.mercadolibre.cupon.domain.PurchaseItems;

public class CalculateItemsToBuy {

    Logger logger = Logger.getLogger(CalculateItemsToBuy.class.getName());

    PurchaseItems purchaseItems;
    CouponValidator couponValidator;

    CalculateItemsToBuy(PurchaseItems purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    public List<String> calculate(Map<String, Float> items, Float coupon) {

        this.couponValidator = CouponValidator.createCouponvalidator(items, coupon);

        if (this.couponValidator.failValueCoupon()){
            logger.log(Level.WARNING, "fail value coupon");
            return new ArrayList<>();
        }

        if (this.couponValidator.CouponGreaterThanItems()){

            logger.log(Level.INFO, "coupon Greather than items values"); 

            return items.entrySet()
                        .stream()
                        .map(e -> e.getKey())
                        .collect(Collectors.toList());
        }
            

        Item[] itemsToEvaluate = processItems(items);

        return purchaseItems.excecute(coupon, itemsToEvaluate);
    }

    private Item[] processItems(Map<String, Float> items) {
        Item[] itemsToEvaluate = new Item[items.size()];
        int indexItem = 0;

        for (Map.Entry<String, Float> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            itemsToEvaluate[indexItem] = Item.createItem(entry.getValue(), entry.getKey());
            indexItem = indexItem + 1;
        }
        return itemsToEvaluate;
    }

}
