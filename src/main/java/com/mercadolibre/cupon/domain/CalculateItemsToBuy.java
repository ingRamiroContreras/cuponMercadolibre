package com.mercadolibre.cupon.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class CalculateItemsToBuy {

    PurchaseItems purchaseItems;

    CalculateItemsToBuy(PurchaseItems purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    public List<String> calculate(Map<String, Float> items, Float coupon) {

        if (!failValueCoupon(coupon))
            return new ArrayList<>();

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

    private boolean failValueCoupon(Float coupon) {

        String digits = String.valueOf(coupon);
        StringTokenizer tokens = new StringTokenizer(digits, ".");

        String numbers = tokens.nextToken();
        String decimals = tokens.nextToken();

        return (decimals.length() <= 2);

    }

}
