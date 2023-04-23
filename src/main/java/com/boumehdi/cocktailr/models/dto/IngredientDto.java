package com.boumehdi.cocktailr.models.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {
    private String name;

    @Override
    public String toString() {
        return "IngredientDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
