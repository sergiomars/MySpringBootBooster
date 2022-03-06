package com.example.springboot.service.pet;

import com.example.springboot.persistence.model.PetPO;
import com.example.springboot.persistence.repository.PetRepository;
import com.example.springboot.service.pet.converter.PetConverter;
import lombok.AllArgsConstructor;
import org.myApi.model.Pet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PetService {

    private PetRepository petRepository;
    private PetConverter petConverter;

    public Pet getPet(int petId) {
        Optional<PetPO> petPO = petRepository.findById(petId);
        if (!petPO.isPresent()) {
            return null; // TODO: throw exception, catch and return a good error message.
        }
        return petConverter.convert(petPO.get());
    }

    public List<Pet> getPets() {
        List<PetPO> allPets = petRepository.findAll();
        return allPets
                .stream()
                .map(petPO -> petConverter.convert(petPO))
                .toList();
    }

    public Pet createPet(Pet pet){
        PetPO petPO = petConverter.convert(pet);
        PetPO savedPet = petRepository.save(petPO);
        return petConverter.convert(savedPet);
    }
}
