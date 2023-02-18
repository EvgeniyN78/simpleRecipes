package pro.sky.simplerecipes.services;

import pro.sky.simplerecipes.model.Recipe;

public interface RecipeService {

    Recipe addRecipe(Recipe recipe);

    Recipe getRecipe(Integer id);
}
