package com.example.springboot.api;

import com.example.springboot.service.pet.PetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.myApi.model.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetControllerTest {

    @InjectMocks
    private PetController petController;

    @Mock
    private PetService petService;

    @Test
    public void createPets() {
        // Given
        var pet = mock(Pet.class);
        var savedPet = mock(Pet.class);
        var savedPetId = 123l;
        when(savedPet.getId()).thenReturn(savedPetId);
        when(petService.createPet(pet)).thenReturn(savedPet);

        // When
        ResponseEntity<Void> response = petController.createPet(pet);

        assertNotNull(response);
        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
        assertThat(
                response.getHeaders().getFirst("location"),
                is(format("/pet/%s", savedPetId)));
    }
}
