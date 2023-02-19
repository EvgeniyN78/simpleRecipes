package pro.sky.simplerecipes.services;

import pro.sky.simplerecipes.model.Ingredient;

public interface IngredientService {

    Ingredient addIngredient(Ingredient ingredient);

    Ingredient getIngredient(Integer id);
}
