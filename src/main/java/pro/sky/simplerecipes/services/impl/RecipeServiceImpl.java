package pro.sky.simplerecipes.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.simplerecipes.model.Ingredient;
import pro.sky.simplerecipes.model.Recipe;
import pro.sky.simplerecipes.services.RecipeService;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final Map<Integer, Recipe> recipeMap = new HashMap<>();
    private static Integer id = 0;

    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipeMap.put(id++, recipe);
        return recipe;
    }

    @Override
    public Recipe getRecipe(Integer id) {
        return recipeMap.getOrDefault(id,null);
    }
}
