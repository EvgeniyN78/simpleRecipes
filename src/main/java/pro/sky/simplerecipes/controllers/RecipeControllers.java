package pro.sky.simplerecipes.controllers;

import jakarta.validation.Valid;
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
    Recipe getRecipe(@PathVariable long id) {
        return recipeService.getRecipe(id);
    }

    @PostMapping
    Recipe addRecipe(@Valid @RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }
}
