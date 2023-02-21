package pro.sky.simplerecipes.services;

import pro.sky.simplerecipes.model.Ingredient;

import java.util.Collection;

public interface IngredientService {

    Integer addIngredient(Ingredient ingredient);

    Ingredient getIngredient(Integer id);

    Ingredient editIngredient(Integer id, Ingredient ingredient);

    boolean deleteIngredient(Integer id);

    Collection<Ingredient> getAllIngredient();
}
