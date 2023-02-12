package pro.sky.simplerecipes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

    @GetMapping(path = "*")
    public String greeting() {
        return "Приложение запущено!";
    }

    @GetMapping("/info")
    public String info() {
        return "Имя ученика: Евгений Непочатых; Название проекта: Простые рецепты; Дата создания проекта: 12.02.2023; Описание проекта: Приложение для сайта рецептов.";
    }
}