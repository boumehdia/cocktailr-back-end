package com.boumehdi.cocktailr.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cocktail")
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Instructions", nullable = false, columnDefinition = "TEXT")
    private String instructions;

    @Column(name = "Category", nullable = false, length = 50)
    private String category;

    @Column(name = "Glass", nullable = false, length = 50)
    private String glass;

    @Column(name = "Alcoholic", nullable = false)
    private Boolean alcoholic;

    @Column(name = "ImageURL", nullable = false, columnDefinition = "TEXT")
    private String imageURL;

    @ManyToMany
    @JoinTable(name="cocktail_ingredient",
            joinColumns = @JoinColumn(name="cocktail_id"),
            inverseJoinColumns = @JoinColumn(name="ingredient_id"))
    private Set<Ingredient> ingredients = new HashSet<>();
    public Cocktail() {}

    public Cocktail(String name, String instructions, String category, String glass, Boolean alcoholic, String imageURL) {
        this.name = name;
        this.instructions = instructions;
        this.category = category;
        this.glass = glass;
        this.alcoholic = alcoholic;
        this.imageURL = imageURL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public Boolean getAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(Boolean alcoholic) {
        this.alcoholic = alcoholic;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Cocktail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instructions='" + instructions + '\'' +
                ", category='" + category + '\'' +
                ", glass='" + glass + '\'' +
                ", alcoholic=" + alcoholic +
                ", imageURL='" + imageURL + '\'' +
                ", ingredients='" + ingredients + '\'' +
                '}';
    }

}
