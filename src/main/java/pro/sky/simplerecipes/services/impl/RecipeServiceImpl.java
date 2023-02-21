package pro.sky.simplerecipes.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.simplerecipes.model.Recipe;
import pro.sky.simplerecipes.services.RecipeService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final Map<Integer, Recipe> recipeMap = new HashMap<>();
    private static Integer id = 0;


    @Override
    public Integer addRecipe(Recipe recipe) {
        for (Recipe recipes : recipeMap.values()) {
            if (recipes.equals(recipe)) {
                return null;
            }
        }
        recipeMap.put(id, recipe);
        return id++;
    }

    @Override
    public Recipe getRecipe(Integer id) {
        for (Integer recipeId : recipeMap.keySet()) {
            if (recipeId.equals(id)) {
                return recipeMap.get(id);
            }
        }
        return null;
    }

    @Override
    public Recipe editRecipe(Integer id, Recipe recipe) {
        if (recipeMap.containsKey(id)) {
            recipeMap.put(id, recipe);
            return recipe;
        }
        return null;
    }

    @Override
    public boolean deleteRecipe(Integer id) {
        if (recipeMap.containsKey(id)) {
            recipeMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Collection<Recipe> getAllRecipe() {
        return recipeMap.values();
    }

}
