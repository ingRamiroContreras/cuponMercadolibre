package com.mercadolibre.cupon.DTO;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemsBuyResponseDto {
    
    @JsonProperty("item_ids")
    private List<String> itemIds;

    @JsonProperty("total")
    private Float total;

    public List<String> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<String> itemIds) {
        this.itemIds = itemIds;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    ItemsBuyResponseDto(List<String> itemIds, Float total){
        this.setItemIds(itemIds);
        this.setTotal(total);
    }

    public static ItemsBuyResponseDto CreateItemsBuyResponseDto(Map<String,Float> itemsWithValues, List<String> itemsToBuy){
        
        Float total = 0F;

        for (String item : itemsToBuy) {
            total = total + itemsWithValues.get(item);
        }

        return new ItemsBuyResponseDto(itemsToBuy,total);
    }

    
}