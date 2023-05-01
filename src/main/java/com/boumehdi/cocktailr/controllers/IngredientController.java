package com.boumehdi.cocktailr.controllers;

import com.boumehdi.cocktailr.models.Cocktail;
import com.boumehdi.cocktailr.models.Ingredient;
import com.boumehdi.cocktailr.models.dto.IngredientDto;
import com.boumehdi.cocktailr.services.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class IngredientController {
    private IngredientService ingredientService;
    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }
    @PostMapping("/ingredient")
    public ResponseEntity<Ingredient> addIngredient(@RequestBody IngredientDto ingredient){
        System.out.println("POST > ingredient = " + ingredient);
        Ingredient createdIngredient = this.ingredientService.postIngredient(ingredient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIngredient);

    }
    @GetMapping("/ingredient/{id}")
    public List<Ingredient> getIngredient(@PathVariable(required=false) Long id){
        System.out.println("GET > ingredient id = " + id);
        return ingredientService.getIngredient(id);
    }
    @GetMapping("/ingredient")
    public List<Ingredient> getAllIngredients(){
        return ingredientService.getIngredient(null);
    }
    @DeleteMapping("/ingredient/{id}")
    public ResponseEntity deleteIngredient(@PathVariable Long id){
        this.ingredientService.deleteIngredient(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping("/ingredient/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id,@RequestBody IngredientDto ingredient) {
        this.ingredientService.updateIngredient(id, ingredient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
