package pro.sky.simplerecipes.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.simplerecipes.model.Recipe;
import pro.sky.simplerecipes.services.RecipeService;

import java.util.Collection;

@RestController
@RequestMapping("/recipe")
//@Tag(name = "Рецепты", description = "CRUD-операции для работы с рецептами")
public class RecipeControllers {

    private final RecipeService recipeService;

    public RecipeControllers(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
//    @Operation(summary = "Добавление рецептов")
    public ResponseEntity<Integer> addRecipe(@RequestBody Recipe recipe) {
        Integer id = recipeService.addRecipe(recipe);
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Integer id) {
        Recipe recipe = recipeService.getRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable Integer id, @RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.getRecipe(id);
        if (newRecipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newRecipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Integer id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/AllRecipes")
    public Collection<Recipe> getAllRecipe() {
        return this.recipeService.getAllRecipe();
    }

}
