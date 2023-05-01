package com.boumehdi.cocktailr.services;
import com.boumehdi.cocktailr.mappers.CocktailMapper;
import com.boumehdi.cocktailr.models.Ingredient;
import com.boumehdi.cocktailr.models.dto.CocktailDto;
import com.boumehdi.cocktailr.models.Cocktail;
import com.boumehdi.cocktailr.repositories.CocktailRepository;

import com.boumehdi.cocktailr.exceptions.ApiException;
import com.boumehdi.cocktailr.repositories.IngredientRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CocktailService {
    // Repository is used to access BDD
    private CocktailRepository repository;
    private IngredientRepository ingredientRepository;
    private CocktailMapper mapper;

    public CocktailService(CocktailRepository repo,IngredientRepository ingRepo, CocktailMapper map)
    {
        super();
        this.repository = repo;
        this.ingredientRepository = ingRepo;
        this.mapper = map;
    }

    public Cocktail postCocktail(CocktailDto cocktail)
    {
        // Verify if cocktail with this name is not already in our database
        if(!repository.findByName(cocktail.getName()).isEmpty()){
            throw new ApiException("Cocktail with this name already exists", HttpStatus.CONFLICT);
        }

        // Create a Cocktail from the CocktailDto (to add ID)
        Cocktail c = mapper.cocktailDtoToCocktail(cocktail);

        // Save Cocktail in database, and return created object
        c = repository.save(c);
        return repository.save(c);
    }

    public List<Cocktail> getCocktail(Long id)
    {
        if(null != id){
            return repository.findAllById(id);
        }
        else{
            return repository.findAll();
        }
    }

    public void deleteCocktail(Long id)
    {
        repository.deleteById(Math.toIntExact(id));
    }

    public void updateCocktail(Long id, CocktailDto cocktail) {
        Cocktail updateCocktail = repository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new ResourceNotFoundException("Cocktail not found with this id: " + id));
        updateCocktail.setAlcoholic(cocktail.getAlcoholic());
        updateCocktail.setCategory(cocktail.getCategory());
        updateCocktail.setGlass(cocktail.getGlass());
        updateCocktail.setName(cocktail.getName());
        updateCocktail.setInstructions(cocktail.getInstructions());
        updateCocktail.setImageURL(cocktail.getImageURL());
        updateCocktail.setIngredients(cocktail.getIngredients());

        repository.save(updateCocktail);
    }

    public Cocktail assignIngredientToCocktail(Long cocktailId, Long ingredientId) {
        Set<Ingredient> ingredients = null;
        Cocktail cocktail = repository.findById(Math.toIntExact(cocktailId)).get();
        Ingredient ingredient = ingredientRepository.findById(Math.toIntExact(ingredientId)).get();

        ingredients = cocktail.getIngredients();
        ingredients.add(ingredient);
        cocktail.setIngredients(ingredients);

        return repository.save(cocktail);
    }
}
