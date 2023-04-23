package com.boumehdi.cocktailr.services;
import com.boumehdi.cocktailr.mappers.IngredientMapper;
import com.boumehdi.cocktailr.models.dto.IngredientDto;
import com.boumehdi.cocktailr.models.Ingredient;
import com.boumehdi.cocktailr.repositories.IngredientRepository;

import com.boumehdi.cocktailr.exceptions.ApiException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    // Repository is used to access BDD
    private IngredientRepository repository;
    private IngredientMapper mapper;

    public IngredientService(IngredientRepository repo, IngredientMapper map)
    {
        super();
        this.repository = repo;
        this.mapper = map;
    }

    public Ingredient postIngredient(IngredientDto ingredient)
    {
        // Verify if ingredient with this name is not already in our database
        if(!repository.findByName(ingredient.getName()).isEmpty()){
            throw new ApiException("Ingredient with this name already exists", HttpStatus.CONFLICT);
        }

        // Create an Ingredient from the IngredientDto (to add ID)
        Ingredient i = mapper.ingredientDtoToIngredient(ingredient);

        // Save Ingredient in database, and return created object
        return repository.save(i);
    }

    public List<Ingredient> getIngredient(Long id)
    {
        if(null != id){
            return repository.findAllById(id);
        }
        else{
            return repository.findAll();
        }
    }

    public void deleteIngredient(Long id)
    {
        repository.deleteById(Math.toIntExact(id));
    }

    public void updateIngredient(Long id, IngredientDto ingredient) {
        Ingredient updateIngredient = repository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found with this id: " + id));

        updateIngredient.setName(ingredient.getName());

        repository.save(updateIngredient);
    }

}
