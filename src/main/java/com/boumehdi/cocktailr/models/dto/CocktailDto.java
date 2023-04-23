package com.boumehdi.cocktailr.models.dto;

import com.boumehdi.cocktailr.models.Ingredient;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CocktailDto {
    private String name;
    private String instructions;
    private String category;
    private String glass;
    private Boolean alcoholic;
    private String imageURL;
    private Set<Ingredient> ingredients;

    @Override
    public String toString() {
        return "CocktailDto{" +
                "name='" + name + '\'' +
                ", instructions='" + instructions + '\'' +
                ", category='" + category + '\'' +
                ", glass='" + glass + '\'' +
                ", alcoholic=" + alcoholic +
                ", imageURL='" + imageURL + '\'' +
                ", ingredients='" + ingredients + '\'' +
                '}';
    }
}
