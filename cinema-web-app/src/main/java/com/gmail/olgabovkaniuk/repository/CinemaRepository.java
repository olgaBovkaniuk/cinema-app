package com.gmail.olgabovkaniuk.repository;

import com.gmail.olgabovkaniuk.domain.Director;
import com.gmail.olgabovkaniuk.domain.Film;

import java.sql.Date;
import java.util.List;

public interface CinemaRepository {

    List<Film> getFilms(Date from, Date to, Long directorId);

    Director findDirectorById(Long directorId);
}
