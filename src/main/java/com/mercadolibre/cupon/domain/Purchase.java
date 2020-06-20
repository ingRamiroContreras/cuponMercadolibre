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
     
    public void setValue(int peso) {
        this.value = peso;
    }
 

 
    /**
     * Añade un elemento a la mochila
     * @param e 
     */
    public void addItem(Item e) {
 
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                this.items[i] = e; //lo añade
                this.value+=e.getValue(); // Aumenta el piso
                break;
            }
        }
 
    }
 
    /**
     * Vaciamos la mochila
     */
    public void clear() {
        this.value=0;
        for (int i = 0; i < this.items.length; i++) {
            this.items[i] = null;
        }
    }
 
    /**
     * Elimina elemento dado
     * @param e 
     */
    public void deleteItem(Item e) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].equals(e)) {
                this.items[i] = null; //el elemento fuera
                this.value-=e.getValue(); //Reduce el peso
                break;
            }
        }
    }
     
    /**
     * Indica si existe un elemento
     * @param e
     * @return 
     */
    public boolean existItem(Item e) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
 
    /**
     * Muestra la mochila
     * @return 
     */
    public String toString() {
        String cadena="";
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                cadena+=items[i]+"\n";
            }
        }
        cadena+="Peso: " + getValue()+"\n";
        return cadena;
    }

    public Float getValueCoupon() {
        return valueCoupon;
    }

    public void setValueCoupon(Float valorCupon) {
        this.valueCoupon = valorCupon;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }
 
}