package com.example.springboot.api;

import com.example.springboot.service.pet.PetService;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.myApi.api.PetApi;
import org.myApi.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PetController implements PetApi {

    private PetService petService;

    @Override
    public ResponseEntity<Pet> showPetById(
            @ApiParam(value = "The id of the pet to retrieve", required = true) @PathVariable("petId") String petId) {
        var pet = petService.getPet(Integer.parseInt(petId)); // TODO: string or int as id?
        return ResponseEntity.ok(pet);
    }

    @Override
    public ResponseEntity<Void> createPet() {

        return ResponseEntity.ok().build();
    }
}
