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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((itemIds == null) ? 0 : itemIds.hashCode());
        result = prime * result + ((total == null) ? 0 : total.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemsBuyResponseDto other = (ItemsBuyResponseDto) obj;
        if (itemIds == null) {
            if (other.itemIds != null)
                return false;
        } else if (!itemIds.equals(other.itemIds))
            return false;
        if (total == null) {
            if (other.total != null)
                return false;
        } else if (!total.equals(other.total))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ItemsBuyResponseDto [itemIds=" + itemIds + ", total=" + total + "]";
    }

    

    
}