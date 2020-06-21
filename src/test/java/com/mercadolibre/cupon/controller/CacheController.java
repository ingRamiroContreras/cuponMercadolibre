package com.mercadolibre.cupon.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CacheController {

    @LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;


    @Test
    public void cleartChacheTest(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> response = this.restTemplate.exchange("http://localhost:" + port + "/cache",HttpMethod.DELETE, null, String.class);
        
        assertEquals("200 OK",response.getStatusCode().toString());
        
    }

    @Test
    public void cleartChacheWithNameCacheTest(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> response = this.restTemplate.exchange("http://localhost:" + port + "/cache/coupon",HttpMethod.DELETE, null, String.class);
        
        assertEquals("200 OK",response.getStatusCode().toString());
        
    }
    
}