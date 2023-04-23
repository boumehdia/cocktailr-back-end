package com.boumehdi.cocktailr.mappers;

import org.mapstruct.Mapper;
import com.boumehdi.cocktailr.models.Cocktail;
import com.boumehdi.cocktailr.models.dto.CocktailDto;

@Mapper(componentModel="spring")
public interface CocktailMapper {
    Cocktail cocktailDtoToCocktail(CocktailDto cocktailDto);
    CocktailDto cocktailToCocktailDto(Cocktail cocktail);
}
