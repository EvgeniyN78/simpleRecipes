package pro.sky.simplerecipes.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pro.sky.simplerecipes.model.Ingredient;
import pro.sky.simplerecipes.services.IngredientService;


@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    private final IngredientService ingredientService;

    @GetMapping("/{id}")
    Ingredient getIngredient(@PathVariable Integer id) {
        return ingredientService.getIngredient(id);
    }

    @PostMapping
    Ingredient addIngredient(@Valid @RequestBody Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }

}
