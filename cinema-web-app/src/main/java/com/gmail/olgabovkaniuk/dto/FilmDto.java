package com.gmail.olgabovkaniuk.dto;

public class FilmDto {
    private String filmName;
    private String filmReleaseDate;
    private String filmGenre;
    private String directorFirstName;
    private String directorLastName;
    private String directorBirthDate;

    public FilmDto(String filmName, String filmReleaseDate, String filmGenre, String directorFirstName, String directorLastName, String directorBirthDate) {
        this.filmName = filmName;
        this.filmReleaseDate = filmReleaseDate;
        this.filmGenre = filmGenre;
        this.directorFirstName = directorFirstName;
        this.directorLastName = directorLastName;
        this.directorBirthDate = directorBirthDate;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmReleaseDate() {
        return filmReleaseDate;
    }

    public void setFilmReleaseDate(String filmReleaseDate) {
        this.filmReleaseDate = filmReleaseDate;
    }

    public String getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(String filmGenre) {
        this.filmGenre = filmGenre;
    }

    public String getDirectorBirthDate() {
        return directorBirthDate;
    }

    public void setDirectorBirthDate(String directorBirthDate) {
        this.directorBirthDate = directorBirthDate;
    }

    public String getDirectorFirstName() {
        return directorFirstName;
    }

    public void setDirectorFirstName(String directorFirstName) {
        this.directorFirstName = directorFirstName;
    }

    public String getDirectorLastName() {
        return directorLastName;
    }

    public void setDirectorLastName(String directorLastName) {
        this.directorLastName = directorLastName;
    }
}
