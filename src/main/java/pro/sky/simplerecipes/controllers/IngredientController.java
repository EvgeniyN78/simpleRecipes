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
import pro.sky.simplerecipes.services.IngredientService;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/ingredient")
//@Tag(name = "Ингредиенты", description = "CRUD-операции для работы с ингредиентами")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

//    @GetMapping("/{id}")
//    @Operation(summary = "поиск ингредиента по id")
//    @ApiResponses(value = {
//            @ApiResponse(
//                    responseCode = "200", description = "ингредиент найден", content = {
//                    @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = Ingredient.class))
//            })
//    })
//    @Parameters(value = {@Parameter(name = "id", example = "1")})
    public ResponseEntity<Ingredient> getIngredient(@PathVariable Integer id) {
        Ingredient ingredient = ingredientService.getIngredient(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

//    @Operation(summary = "Добавление ингредиента")
//    @ApiResponses(value = {
//            @ApiResponse(
//                    responseCode = "200",
//                    description = "ингредиент добавлен",
//                    content = {
//                            @Content(
//                                    mediaType = "application/json",
//                                    schema = @Schema(implementation = Ingredient.class)
//                            )
//                    }
//            )
//    })
    @PostMapping
    public ResponseEntity<Integer> addIngredient(@Valid @RequestBody Ingredient ingredient) {
        Integer id = ingredientService.addIngredient(ingredient);
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> editIngredient(@PathVariable Integer id, @RequestBody Ingredient ingredient) {
        Ingredient newIngredient = ingredientService.getIngredient(id);
        if (newIngredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newIngredient);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "удаление ингредиента по id")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Integer id) {
        if (ingredientService.deleteIngredient(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/AllIngredients")
//    @Operation(description = "получение всех ингредиентов")
    public Collection<Ingredient> getAllIngredient() {
        return this.ingredientService.getAllIngredient();
    }
}
