package com.example.springboot.api;

import io.swagger.annotations.ApiParam;
import org.myApi.api.PetsApi;
import org.myApi.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetsController implements PetsApi {

    @Override
    public ResponseEntity<Pet> showPetById(@ApiParam(value = "The id of the pet to retrieve", required = true) @PathVariable("petId") String petId) {
        return ResponseEntity.ok(new Pet());
    }

    @Override
    public ResponseEntity<Void> createPets() {

        return ResponseEntity.ok().build();
    }
}
