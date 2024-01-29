package ru.maliutin.rickandmortyapi.services;


import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.maliutin.rickandmortyapi.models.UrlApi;


import java.util.List;

/**
 * Имплементация сервисного интерфейса.
 */
@Service
public class ServiceApiImpl implements ServiceApi{

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
    public String getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = template.exchange(
                urlApi.getCharacterAll(),
                HttpMethod.GET,
                entity, String.class);

        return response.getBody();
    }

    public String getAllCharacters(String page) {
        System.out.println("zapros = " + urlApi.getCharacterAll()+ "?page=" + page);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = template.exchange(
                urlApi.getCharacterAll()+ "?page=" + page,
                HttpMethod.GET,
                entity,
                String.class);

        return response.getBody();
    }

    /**
     * Получение конкретного персонажа.
     * @param id идентификатор персонажа.
     * @return json ответ с персонажем.
     */
    @Override
    public String getHero(Integer id) {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = template.exchange(
                (urlApi.getCharacter() + id),
                HttpMethod.GET,
                entity,
                String.class
        );

        return response.getBody();
    }
}
