package com.mercadolibre.cupon.app.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemsBuyRequestDto {
    
    @JsonProperty("item_ids")
    private List<String> itemIds;

    @JsonProperty("amount")
    private Float amount;

    public List<String> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<String> itemIds) {
        this.itemIds = itemIds;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        result = prime * result + ((itemIds == null) ? 0 : itemIds.hashCode());
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
        ItemsBuyRequestDto other = (ItemsBuyRequestDto) obj;
        if (amount == null) {
            if (other.amount != null)
                return false;
        } else if (!amount.equals(other.amount))
            return false;
        if (itemIds == null) {
            if (other.itemIds != null)
                return false;
        } else if (!itemIds.equals(other.itemIds))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ItemsBuyRequestDto [amount=" + amount + ", itemIds=" + itemIds + "]";
    }

    

    
}