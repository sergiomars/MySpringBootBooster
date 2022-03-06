package com.example.springboot.service.pet.converter;

import com.example.springboot.persistence.model.PetPO;
import org.myApi.model.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetConverter {

    public Pet convert(PetPO petPO) {
        var pet = new Pet();
        pet.setId((long) petPO.getId());
        pet.setName(petPO.getName());
        pet.setTag(petPO.getTag());
        return pet;
    }

    public PetPO convert(Pet pet) {
        var petPO = new PetPO();
        petPO.setName(pet.getName());
        petPO.setTag(pet.getTag());
        return petPO;
    }
}
