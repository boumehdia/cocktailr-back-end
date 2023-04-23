package com.boumehdi.cocktailr.mappers;

import org.mapstruct.Mapper;
import com.boumehdi.cocktailr.models.Ingredient;
import com.boumehdi.cocktailr.models.dto.IngredientDto;

@Mapper(componentModel="spring")
public interface IngredientMapper {
    Ingredient ingredientDtoToIngredient(IngredientDto ingredientDto);
    IngredientDto ingredientToIngredientDto(Ingredient ingredient);
}
