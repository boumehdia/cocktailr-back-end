package com.boumehdi.cocktailr.repositories;

import com.boumehdi.cocktailr.models.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Integer> {
    List<Cocktail> findAllById(Long id);
    List<Cocktail> findByName(String name);
}

// save(), findById(), findAll()