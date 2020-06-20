package com.mercadolibre.cupon.domain;

public class Purchase {
 
    private Float valueCoupon;
    private Item[] items;
 
    private int value;
 
    public Purchase(Float valueCoupon, int numItems) {
        this.valueCoupon = valueCoupon;
        this.items = new Item[numItems];
        this.value = 0;
    }
 
    public Item[] getItems() {
        return items;
    }
 
     public int getValue() {
       return value;
    }
     
    public void setValue(int value) {
        this.value = value;
    }
 

    public void addItem(Item e) {
 
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                this.items[i] = e; 
                this.value+=e.getValue(); 
                break;
            }
        }
 
    }
 
 
    public void clear() {
        this.value=0;
        for (int i = 0; i < this.items.length; i++) {
            this.items[i] = null;
        }
    }
 
   
    public void deleteItem(Item e) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].equals(e)) {
                this.items[i] = null; 
                this.value-=e.getValue();
                break;
            }
        }
    }
     
   
    public boolean existItem(Item e) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
 
  
    public String toString() {
        String cadena="";
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                cadena+=items[i]+"\n";
            }
        }
        cadena+="Value: " + getValue()+"\n";
        return cadena;
    }

    public Float getValueCoupon() {
        return valueCoupon;
    }

    public void setValueCoupon(Float valueCoupon) {
        this.valueCoupon = valueCoupon;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }
 
}