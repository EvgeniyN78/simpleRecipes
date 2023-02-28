package pro.sky.simplerecipes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingredient {

    private String name;
    private Integer count;
    private String measureUnit;

}
