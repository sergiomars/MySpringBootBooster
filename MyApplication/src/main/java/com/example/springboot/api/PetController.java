package com.example.springboot.api;

import com.example.springboot.service.pet.PetService;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.myApi.api.PetApi;
import org.myApi.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@RestController
@AllArgsConstructor
public class PetController implements PetApi {

    private PetService petService;

    @Override
    public ResponseEntity<Pet> showPetById(
            @ApiParam(value = "The id of the pet to retrieve", required = true) @PathVariable("petId") String petId) {
        var pet = petService.getPet(Integer.parseInt(petId)); // TODO: string or int as id?
        return ok(pet);
    }

    @Override
    public ResponseEntity<Void> createPet(
            @ApiParam(value = "Create a new pet in the store", required = true) @Valid @RequestBody Pet pet) {

        Pet savedPet = petService.createPet(pet);

        URI location = fromUriString("/pet")
                .path("/{id}")
                .buildAndExpand(savedPet.getId())
                .toUri();
        return created(location).build();
    }

    @Override
    public ResponseEntity<List<Pet>> listPets(
            @ApiParam(value = "How many items to return at one time (max 100)") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        return ok(petService.getPets());
    }

}
