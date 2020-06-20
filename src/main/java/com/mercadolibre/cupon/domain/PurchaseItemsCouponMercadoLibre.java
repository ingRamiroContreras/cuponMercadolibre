package com.mercadolibre.cupon.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PurchaseItemsCouponMercadoLibre implements PurchaseItems {

    @Override
    public List<String> excecute(Float valueCoupon, Item[] items) {

        Purchase purchaseBase = new Purchase(valueCoupon, items.length);
        Purchase bestOptionPurchase = new Purchase(valueCoupon, items.length);

        generateBestPurchase(purchaseBase, bestOptionPurchase, items, false);

        return ProcessResponse(bestOptionPurchase);
    }

    private List<String> ProcessResponse(Purchase bestOptionPurchase) {

        List<String> bestOptionListItems = new ArrayList<>();

        for (int i = 0; i < bestOptionPurchase.getItems().length; i++) {

            Optional<Item> opt = Optional.ofNullable(bestOptionPurchase.getItems()[i]);

            if (opt.isPresent())
                bestOptionListItems.add(opt.get().getNameItem());

        }

        return bestOptionListItems;
    }

    private static void generateBestPurchase(Purchase purchaseBase, Purchase bestOptionPurchase, Item[] items,
            boolean full) {

        if (full) {

            if ((purchaseBase.getValueCoupon() - purchaseBase.getValue()) < (bestOptionPurchase.getValueCoupon()
                    - bestOptionPurchase.getValue())) {

                Item[] elementosBase = purchaseBase.getItems();

                bestOptionPurchase.clear();

                for (Item elemento : elementosBase) {
                    if (elemento != null) {

                        bestOptionPurchase.addItem(elemento);
                    }
                }

            }

        } else {

            for (int i = 0; i < items.length; i++) {
                if (!purchaseBase.existItem(items[i])) {
                    if (purchaseBase.getValueCoupon() >= purchaseBase.getValue() + items[i].getValue()) {
                        purchaseBase.addItem(items[i]);
                        generateBestPurchase(purchaseBase, bestOptionPurchase, items, false);
                        purchaseBase.deleteItem(items[i]);
                    } else {
                        generateBestPurchase(purchaseBase, bestOptionPurchase, items, true);

                    }
                }
            }

        }

    }

}