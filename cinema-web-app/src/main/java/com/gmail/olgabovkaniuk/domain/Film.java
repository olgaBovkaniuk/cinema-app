package com.gmail.olgabovkaniuk.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity(name = "film")
public class Film implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "genre")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "director_id", insertable = false, updatable = false)
    private Director director;

    public Film() {
    }

    public Film(String name, Date releaseDate, String genre, Director director) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.director = director;
    }

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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (id != film.id) return false;
        if (name != null ? !name.equals(film.name) : film.name != null) return false;
        if (releaseDate != null ? !releaseDate.equals(film.releaseDate) : film.releaseDate != null) return false;
        if (genre != null ? !genre.equals(film.genre) : film.genre != null) return false;
        return director != null ? director.equals(film.director) : film.director == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        return result;
    }
}
