package com.example.springboot.api;

import org.myApi.api.PetsApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetsController implements PetsApi {

    @Override
    public ResponseEntity<Void> createPets() {

        return ResponseEntity.ok().build();
    }
}
