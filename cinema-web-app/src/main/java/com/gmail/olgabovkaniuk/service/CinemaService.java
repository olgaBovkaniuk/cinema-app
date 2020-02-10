package com.gmail.olgabovkaniuk.service;

import com.gmail.olgabovkaniuk.controller.QueryParam;
import com.gmail.olgabovkaniuk.dto.FilmDto;

import java.util.List;

public interface CinemaService {

    List<FilmDto> getFilmInfo(QueryParam queryParam);

    boolean isDirectorWithIdExist(Long directorId);
}
