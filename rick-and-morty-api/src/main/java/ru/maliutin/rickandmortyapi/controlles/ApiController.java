package ru.maliutin.rickandmortyapi.controlles;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.maliutin.rickandmortyapi.services.ServiceApi;

/**
 * Контроллер обработки поступающих запросов.
 */
@RestController
public class ApiController {
    /**
     * Сервис запросов удаленного API.
     */
    private final ServiceApi serviceApi;

    public ApiController(ServiceApi serviceApi) {
        this.serviceApi = serviceApi;
    }

    /**
     * Получение списка героев сериала.
     * @param page страница списка.
     * @return Json ответ со списком героев.
     */
    @GetMapping("/")
    public ResponseEntity<String> getCharacters(
            @RequestParam(value = "page", required = false) String page){
        if (page != null){
            return ResponseEntity.ok().body(serviceApi.getAllCharacters(page));
        }
        return ResponseEntity.ok().body(serviceApi.getAllCharacters());
    }

    /**
     * Получение данных конкретного героя.
     * @param id идентификатор героя.
     * @return Json ответ с конкретным героем.
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getCharacter(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(serviceApi.getHero(id));
    }
}
