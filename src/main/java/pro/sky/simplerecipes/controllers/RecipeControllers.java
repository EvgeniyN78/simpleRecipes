package pro.sky.simplerecipes.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.simplerecipes.model.Ingredient;
import pro.sky.simplerecipes.model.Recipe;
import pro.sky.simplerecipes.services.RecipeService;

import java.util.Collection;

@RestController
@RequestMapping("/recipe")
@Tag(name = "Рецепты", description = "CRUD-операции для работы с рецептами")
public class RecipeControllers {

    private final RecipeService recipeService;

    public RecipeControllers(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    @Operation(summary = "Добавление рецепта")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "рецепт добавлен",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Recipe.class)
                            )
                    }
            )
    })
    public ResponseEntity<Integer> addRecipe(@RequestBody Recipe recipe) {
        Integer id = recipeService.addRecipe(recipe);
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Поиск рецепта по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "рецепт найден", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Recipe.class))
            })
    })
    @Parameters(value = {@Parameter(name = "id", example = "1")})
    public ResponseEntity<Recipe> getRecipe(@PathVariable Integer id) {
        Recipe recipe = recipeService.getRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Редактирование рецепта по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "рецепт отредактирован", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Recipe.class))
            })
    })
    @Parameters(value = {@Parameter(name = "id", example = "1")})
    public ResponseEntity<Recipe> editRecipe(@PathVariable Integer id, @RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.getRecipe(id);
        if (newRecipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newRecipe);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление рецепта по id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "рецепт удалён"
            )
    })
    @Parameters(value = {@Parameter(name = "id", example = "1")})
    public ResponseEntity<Void> deleteRecipe(@PathVariable Integer id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/AllRecipes")
    @Operation(summary = "Получение всех рецептов", description = "Поиск происходит без параметров")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "все рецепты получены",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Recipe.class)
                            )
                    }
            )
    })
    public Collection<Recipe> getAllRecipe() {
        return this.recipeService.getAllRecipe();
    }

}
