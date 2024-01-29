package ru.maliutin.rickandmortyweb.services;


import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.maliutin.rickandmortyweb.models.Characters;
import ru.maliutin.rickandmortyweb.models.Result;
import ru.maliutin.rickandmortyweb.models.UrlApi;


import java.util.List;

/**
 * Имплементация сервисного интерфейса.
 */
@Service
public class ServiceApiImpl implements ServiceApi {

    /**
     * Библиотека для создания запроса.
     */
    private final RestTemplate template;
    /**
     * Заголовок запроса.
     */
    private final HttpHeaders headers;
    /**
     * Запросы к API.
     */
    private final UrlApi urlApi;

    public ServiceApiImpl(RestTemplate template, HttpHeaders headers, UrlApi urlApi) {
        this.template = template;
        this.headers = headers;
        this.urlApi = urlApi;
    }

    /**
     * Получение всех персонажей.
     * @return json ответ с метаданными и персонажами.
     */
    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> response = template.exchange(
                urlApi.getGetCharacters(),
                HttpMethod.GET,
                entity,
                Characters.class);

        return response.getBody();
    }

    /**
     * Получение всех пользователей по номеру страницы.
     * @param page номер страницы.
     * @return список пользователей с метаданными.
     */
    public Characters getAllCharacters(Integer page) {
        System.out.println("В сервисе page = " + page);
        System.out.println("zapros = " + urlApi.getGetCharacters() + "?page=" + page);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> response = template.exchange(
                urlApi.getGetCharacters() + "?page=" + page,
                HttpMethod.GET,
                entity,
                Characters.class);
        System.out.println("otvet s api poluchen");
        return response.getBody();
    }

    /**
     * Получение конкретного персонажа.
     * @param id идентификатор персонажа.
     * @return конкретный персонаж.
     */
    @Override
    public Result getHero(Integer id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Result> response = template.exchange(
                (urlApi.getGetCharacters() + id),
                HttpMethod.GET,
                entity,
                Result.class
        );

        return response.getBody();
    }
}
