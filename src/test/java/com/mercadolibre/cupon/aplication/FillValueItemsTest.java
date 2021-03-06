package com.mercadolibre.cupon.aplication;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mercadolibre.cupon.domain.ItemsService;
import com.mercadolibre.cupon.infraestructure.InMemoryItemsRepository;
import com.mercadolibre.cupon.infraestructure.MercadoLibreItems;
import com.mercadolibre.cupon.infraestructure.SendMercadoLIbreRequest;

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

        ItemsService mercalodibreItemsRepository = new InMemoryItemsRepository();
        FillItems fillValueItems =  FillValueItems.createFillValueItems(mercalodibreItemsRepository);

        /**
         * Excecute Test
         */

        Map<String,Float> ItemsWithValues = fillValueItems.getValuesItem(items);


        assertNotNull(ItemsWithValues.get("MLA1"));
        assertNotNull(ItemsWithValues.get("MLA2"));
        assertNotNull(ItemsWithValues.get("MLA3"));
        assertNotNull(ItemsWithValues.get("MLA4"));


    }

    @Test
    public void setValuesInItemsMercadoLibreRepository(){
        /**
         * SetUp
         */

        List<String> items = new ArrayList<>();
        items.add("MLA811601010");
        items.add("MLA811601014");

        ItemsService mercalodibreItemsRepository = new MercadoLibreItems(new SendMercadoLIbreRequest());
        FillItems fillValueItems =  FillValueItems.createFillValueItems(mercalodibreItemsRepository);

        /**
         * Excecute Test
         */

        Map<String,Float> ItemsWithValues = fillValueItems.getValuesItem(items);


        assertNotNull(ItemsWithValues.get("MLA811601010"));
        assertNotNull(ItemsWithValues.get("MLA811601014"));


    }
    
}