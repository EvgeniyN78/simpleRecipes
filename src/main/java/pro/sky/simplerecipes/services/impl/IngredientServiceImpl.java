package pro.sky.simplerecipes.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.simplerecipes.model.Ingredient;
import pro.sky.simplerecipes.services.IngredientService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private static Integer id = 0;

    @Override
    public Integer addIngredient(Ingredient ingredient) {
        for (Ingredient ingredients : ingredientMap.values()) {
            if (ingredients.equals(ingredient)) {
                return null;
            }
        }
        ingredientMap.put(id, ingredient);
        return id++;
    }

    @Override
    public Ingredient getIngredient(Integer id) {
        for (Integer ingredientID : ingredientMap.keySet()) {
            if (ingredientID.equals(id)) {
                return ingredientMap.get(id);
            }
        }
        return null;
    }

    @Override
    public Ingredient editIngredient(Integer id, Ingredient ingredient) {
        if (ingredientMap.containsKey(id)) {
            ingredientMap.put(id, ingredient);
            return ingredient;
        }
        return null;
    }

    @Override
    public boolean deleteIngredient(Integer id) {
        if (ingredientMap.containsKey(id)) {
            ingredientMap.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Collection<Ingredient> getAllIngredient() {
        return ingredientMap.values();
    }
}
