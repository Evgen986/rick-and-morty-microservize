package ru.maliutin.rickandmortyapi.models;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Инкапсулированные запросы к api.
 */
@Data
@Component
@ConfigurationProperties("url.api")
public class UrlApi {
    /**
     * Получение всех персонажей.
     */
    private String characterAll;
    /**
     * Получение конкретного персонажа.
     */
    private String character;

    public String getCharacterAll() {
        return characterAll;
    }

    public void setCharacterAll(String characterAll) {
        this.characterAll = characterAll;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
