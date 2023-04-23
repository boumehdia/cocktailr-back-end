package com.boumehdi.cocktailr.controllers;

import com.boumehdi.cocktailr.models.Cocktail;
import com.boumehdi.cocktailr.models.dto.CocktailDto;
import com.boumehdi.cocktailr.services.CocktailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CocktailController {
    private CocktailService cocktailService;
    public CocktailController(CocktailService cocktailService){
        this.cocktailService = cocktailService;
    }
    @PostMapping("/cocktail")
    public ResponseEntity<Cocktail> addCocktail(@RequestBody CocktailDto cocktail){
        this.cocktailService.postCocktail(cocktail);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
    @GetMapping("/cocktail/{id}")
    public List<Cocktail> getCocktail(@PathVariable(required=false) Long id){
        return cocktailService.getCocktail(id);
    }

    @DeleteMapping("/cocktail/{id}")
    public ResponseEntity deleteCocktail(@PathVariable Long id){
        this.cocktailService.deleteCocktail(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping("/cocktail/{id}")
    public ResponseEntity<Cocktail> updateCocktail(@PathVariable Long id,@RequestBody CocktailDto cocktail) {
        this.cocktailService.updateCocktail(id, cocktail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("cocktail/{cocktailId}/ingredient/{ingredientId}")
    public Cocktail assignIngredientToCocktail(@PathVariable Long cocktailId,@PathVariable Long ingredientId) {
        return this.cocktailService.assignIngredientToCocktail(cocktailId, ingredientId);
    }

}
