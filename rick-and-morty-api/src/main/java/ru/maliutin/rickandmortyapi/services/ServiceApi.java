package ru.maliutin.rickandmortyapi.services;


/**
 * Интерфейс сервиса запросов к api.
 */
public interface ServiceApi {
    /**
     * Получение всех персонажей.
     * @return данные о персонажах и метаданные.
     */
    String getAllCharacters();

    String getAllCharacters(String url);

    /**
     * Получение конкретного персонажа.
     * @param id идентификатор персонажа.
     * @return объект персонажа.
     */
    String getHero(Integer id);
}
