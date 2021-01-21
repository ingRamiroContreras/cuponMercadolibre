package com.mercadolibre.cupon.infraestructure;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

public class SendMercadoLIbreRequest {

    final String URL = "https://api.mercadolibre.com/items/";

    public String invoke(String itemId) {

        try {

            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(URL + itemId, String.class);
            return result;
        } catch (HttpClientErrorException e) {
           
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }

        
    }

    
}
