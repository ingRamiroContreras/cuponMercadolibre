package com.mercadolibre.cupon.infraestructure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.cupon.domain.ItemsRepository;

import org.springframework.web.client.RestTemplate;

public class MercadoLibreItemsRepository implements ItemsRepository {

    @Override
    public Map<String, Float> getValuesItem(List<String> itemsList) {

        RestTemplate restTemplate = new RestTemplate();
        final String URL = "https://api.mercadolibre.com//items?ids=";
        String paramsItems = String.join(",", itemsList);

        String result = restTemplate.getForObject(URL + paramsItems, String.class);
        List<Map<String, Object>> response = mapperJsonResultToListMap(result);

        return mapperResponse(response);

    }

    private Map<String, Float> mapperResponse(List<Map<String, Object>> response) {
        Map<String, Float> respMapper = new HashMap<>();

        for (Map<String, Object> map : response) {
            System.out.println(map);
            Map<String,Object> body = (Map<String,Object>) map.get("body");
            
            //Map<String, String> mapperMap = mapperJsonResultToMap(body);
            Optional<Object> idItem = Optional.ofNullable(body.get("id"));
            Optional<Object> price = Optional.ofNullable(body.get("price"));
            
            if (idItem.isPresent() && price.isPresent()) {
                respMapper.put((String) idItem.get(), ((Integer)price.get()).floatValue());
            }

        }

        return respMapper;
    }

    private Map<String, String> mapperJsonResultToMap(String json) {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();

        try {
            map = mapper.readValue(json, Map.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;

    }

    private List<Map<String, Object>> mapperJsonResultToListMap(String json) {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> map = new ArrayList<>();

        try {
            map = mapper.readValue(json, List.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;

    }
}
