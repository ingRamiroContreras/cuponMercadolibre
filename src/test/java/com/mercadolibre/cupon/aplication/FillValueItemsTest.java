package com.mercadolibre.cupon.aplication;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mercadolibre.cupon.domain.ItemsRepository;
import com.mercadolibre.cupon.infraestructure.InMemoryItemsRepository;

import org.junit.jupiter.api.Test;

public class FillValueItemsTest {

    //private MercalodibreItemsRepositori mercalodibreItemsRepositori

    @Test
    public void setValuesInItems(){
        /**
         * SetUp
         */

        List<String> items = new ArrayList<>();
        items.add("MLA1");
        items.add("MLA2");
        items.add("MLA3");
        items.add("MLA4");

        ItemsRepository mercalodibreItemsRepository = new InMemoryItemsRepository();
        FillValueItems fillValueItems =  new FillValueItems(mercalodibreItemsRepository);

        /**
         * Excecute Test
         */

        Map<String,Float> ItemsWithValues = fillValueItems.getValuesItem(items);


        assertNotNull(ItemsWithValues.get("MLA1"));
        assertNotNull(ItemsWithValues.get("MLA2"));
        assertNotNull(ItemsWithValues.get("MLA3"));
        assertNotNull(ItemsWithValues.get("MLA4"));


    }
    
}