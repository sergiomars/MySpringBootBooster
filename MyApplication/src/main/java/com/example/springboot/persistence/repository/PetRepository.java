package com.example.springboot.persistence.repository;

import com.example.springboot.persistence.model.PetPO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<PetPO, Integer> {

    List<PetPO> findAll();

}
