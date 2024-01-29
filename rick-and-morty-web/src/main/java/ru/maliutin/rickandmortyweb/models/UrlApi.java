package ru.maliutin.rickandmortyweb.models;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Инкапсулированные запросы с api.
 */
@Data
@Component
@ConfigurationProperties("url.api")
public class UrlApi {
    /**
     * Получение данных с api.
     */
    private String getCharacters;

    public String getGetCharacters() {
        return getCharacters;
    }

    public void setGetCharacters(String getCharacters) {
        this.getCharacters = getCharacters;
    }
}
