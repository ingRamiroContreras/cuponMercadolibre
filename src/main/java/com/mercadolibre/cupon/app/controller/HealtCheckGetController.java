package com.mercadolibre.cupon.app.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealtCheckGetController {

    @GetMapping("/health-check")
    public ResponseEntity<HashMap<String, String>> healtCheck() {
        
        HashMap<String, String> status = new HashMap<>();
        status.put("status", "OK");
        
        return new ResponseEntity<HashMap<String, String>>(status, HttpStatus.OK);

    }

}