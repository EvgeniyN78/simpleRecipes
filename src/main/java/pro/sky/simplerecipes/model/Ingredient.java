package pro.sky.simplerecipes.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Ingredient {

    @NotBlank(message = "Наименование не должно быть пустым!")
    private String name;
    @Positive
    private Integer count;
    private String measureUnit;

}
