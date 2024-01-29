package ru.maliutin.rickandmortyweb.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Объект персонажа.
 */
@Data
public class Result {
    /**
     * Идентификатор.
     */
    private Integer id;
    /**
     * Имя.
     */
    private String name;
    /**
     * Статус.
     */
    private String status;
    /**
     * Вид.
     */
    private String species;
    /**
     * Тип.
     */
    private String type;
    /**
     * Половая принадлежность.
     */
    private String gender;
    /**
     * Ссылка на картинку.
     */
    private String image;
    /**
     * Участие в эпизодах.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> episode;
    /**
     * Ссылка на персонажа.
     */
    private String url;
    /**
     * Дата создания.
     */
    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public void setEpisode(List<String> episode) {
        this.episode = episode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
