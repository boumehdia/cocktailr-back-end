package com.boumehdi.cocktailr.repositories;

import com.boumehdi.cocktailr.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findAllById(Long id);
    List<Ingredient> findByName(String name);
}

// save(), findById(), findAll()