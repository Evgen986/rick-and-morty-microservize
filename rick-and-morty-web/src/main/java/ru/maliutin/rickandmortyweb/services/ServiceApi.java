package ru.maliutin.rickandmortyweb.services;


import ru.maliutin.rickandmortyweb.models.Characters;
import ru.maliutin.rickandmortyweb.models.Result;

/**
 * Интерфейс сервиса запросов к api.
 */
public interface ServiceApi {
    /**
     * Получение всех персонажей.
     * @return данные о персонажах и метаданные.
     */
    Characters getAllCharacters();

    Characters getAllCharacters(Integer page);

    /**
     * Получение конкретного персонажа.
     * @param id идентификатор персонажа.
     * @return объект персонажа.
     */
    Result getHero(Integer id);
}
