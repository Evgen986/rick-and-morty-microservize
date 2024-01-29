package ru.maliutin.rickandmortyweb.models;

import lombok.Data;

/**
 * Сущность с информацией для пагинации.
 */
@Data
public class Info {
    /**
     * Количество записей.
     */
    private Integer count;
    /**
     * Количество страниц.
     */
    private Integer pages;
    /**
     * Ссылка на следующую страницу.
     */
    private String next;
    /**
     * Ссылка на предыдущую страницу.
     */
    private String prev;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }
}
