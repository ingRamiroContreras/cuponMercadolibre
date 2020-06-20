package com.mercadolibre.cupon.domain;

public class Item {

    private String nameItem;
    private Float value;

    public Item(Float valor, String nombreArticulo) {
        this.value = valor;
        this.nameItem = nombreArticulo;
    }

    public static Item createItem(Float valor, String nombreArticulo){
        return new Item(valor,nombreArticulo);
    }

  

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nombreArticulo) {
        this.nameItem = nombreArticulo;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float valor) {
        this.value = valor;
    }

    @Override
    public String toString() {
        return "Item [nameItem=" + nameItem + "]";
    }

}