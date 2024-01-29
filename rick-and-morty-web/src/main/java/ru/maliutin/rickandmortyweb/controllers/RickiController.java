package ru.maliutin.rickandmortyweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.maliutin.rickandmortyweb.models.Characters;
import ru.maliutin.rickandmortyweb.services.ServiceApi;

/**
 * Контролер web микросервиса.
 */

@Controller
public class RickiController {
    /**
     * Сервис для работы с микросервисом API.
     */
    private final ServiceApi serviceApi;

    public RickiController(ServiceApi serviceApi) {
        this.serviceApi = serviceApi;
    }

    /**
     * Получение списка героев.
     * @param page номер страницы.
     * @param model модель для передачи данных.
     * @return представление с героями.
     */
    @GetMapping("/")
    public String getAllHeroes(
            @RequestParam(value = "page", required = false)
            Integer page, Model model){
        Characters characters;
        // Проверяем передан ли параметр (номер страницы)
        if (page != null){
            characters = serviceApi.getAllCharacters(page);
        }else{
            characters = serviceApi.getAllCharacters();
        }
        model.addAttribute("heroes", characters.getResults());

        // Проверяем есть ли доступные страницы назад и вперед
        String next = null;
        if (characters.getInfo().getNext() != null){
            next = characters.getInfo().getNext();
            next = next.substring(next.length() - 1);
        }

        String prev = null;
        if (characters.getInfo().getPrev() != null){
            prev = characters.getInfo().getPrev();
            prev = prev.substring(prev.length() - 1);
        }

        model.addAttribute("next", next);
        model.addAttribute("prev", prev);
        return "heroes";
    }

    /**
     * Получение конкретного героя.
     * @param id идентификатор героя.
     * @param model объект для передачи данных в представление.
     * @return представление с конкретным героем.
     */
    @GetMapping("/{id}")
    public String getHero(@PathVariable Integer id, Model model){
        model.addAttribute("hero", serviceApi.getHero(id));
        return "hero";
    }

}
