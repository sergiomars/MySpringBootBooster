package com.example.springboot.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class PetsControllerTest {


    @InjectMocks
    private PetsController petsController;

    @Test
    public void createPets() {

        ResponseEntity<Void> response = petsController.createPets();

        assertNotNull(response);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

}
