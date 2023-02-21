package pro.sky.simplerecipes.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingredient {

    @NotBlank(message = "Наименование должно быть заполнено!")
    private String name;
    @Positive
    private Integer count;
    @NotBlank(message = "Единица измерения должна быть заполнена!")
    private String measureUnit;

}
