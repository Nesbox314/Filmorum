package com.github.Filmorum.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "film")
public class Film {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String avaliation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvaliation() {
        return avaliation;
    }

    public void setAvaliation(String avaliation) {
        this.avaliation = avaliation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id.equals(film.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
