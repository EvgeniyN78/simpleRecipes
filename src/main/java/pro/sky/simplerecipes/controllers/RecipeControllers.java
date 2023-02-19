package pro.sky.simplerecipes.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.simplerecipes.model.Recipe;
import pro.sky.simplerecipes.services.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeControllers {

    private final RecipeService recipeService;

    public RecipeControllers(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    Recipe getRecipe(@PathVariable Integer id) {
        return recipeService.getRecipe(id);
    }

    @PostMapping
    Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }
}
