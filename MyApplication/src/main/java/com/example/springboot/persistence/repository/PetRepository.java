package com.example.springboot.persistence.repository;

import com.example.springboot.persistence.model.PetPO;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<PetPO, Integer> {
}
