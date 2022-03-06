package com.example.springboot.service.pet;

import com.example.springboot.persistence.model.PetPO;
import com.example.springboot.persistence.repository.PetRepository;
import com.example.springboot.service.pet.converter.PetConverter;
import lombok.AllArgsConstructor;
import org.myApi.model.Pet;
import org.springframework.stereotype.Service;

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
}
