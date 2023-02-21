package pro.sky.simplerecipes.services;

import pro.sky.simplerecipes.model.Recipe;

import java.util.Collection;

public interface RecipeService {

    Integer addRecipe(Recipe recipe);

    Recipe getRecipe(Integer id);

    Recipe editRecipe(Integer id, Recipe recipe);

    boolean deleteRecipe(Integer id);

    Collection<Recipe> getAllRecipe();
}
