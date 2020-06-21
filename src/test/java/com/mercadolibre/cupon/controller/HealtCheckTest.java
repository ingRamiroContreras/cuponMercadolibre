package com.mercadolibre.cupon.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
public class HealtCheckTest {

    @LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	

	public void cleartChacheTest(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> response = this.restTemplate.exchange("http://localhost:" + port + "/health-check",HttpMethod.GET, null, String.class);

        assertEquals("200 OK",response.getStatusCode().toString());
        
    }
    
}