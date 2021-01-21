package com.mercadolibre.cupon.infraestructure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.cupon.domain.ItemsService;



public class MercadoLibreItems implements ItemsService {


    private SendMercadoLIbreRequest sendMercadoLIbreREquest;


    

    @Override
    public Map<String, Float> getValuesItem(List<String> itemsList) {
        
        List<Map<String, Object>> response = new ArrayList<>();

        for (String itemId : itemsList) {
            String result = sendMercadoLIbreREquest.invoke(itemId);
            response.add(mapperJsonResultToListMap(result));
        }
        
        return mapperResponse(response);

    }

    private Map<String, Float> mapperResponse(List<Map<String, Object>> response) {
        Map<String, Float> respMapper = new HashMap<>();

        for (Map<String, Object> map : response) {
            
            Optional<Object> idItem = Optional.ofNullable(map.get("id"));
            Optional<Object> price = Optional.ofNullable(map.get("price"));
            
            if (idItem.isPresent() && price.isPresent()) {
                respMapper.put((String) idItem.get(), ((Integer)price.get()).floatValue());
            }

        }

        return respMapper;
    }


    private Map<String, Object> mapperJsonResultToListMap(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new LinkedHashMap<>();

        try {
            map = mapper.readValue(json, Map.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;

    }

    public MercadoLibreItems(SendMercadoLIbreRequest sendMercadoLIbreREquest) {
        this.sendMercadoLIbreREquest = sendMercadoLIbreREquest;
    }
}
