package com.gmail.olgabovkaniuk.service;

import com.gmail.olgabovkaniuk.controller.QueryParam;
import com.gmail.olgabovkaniuk.converter.FilmDomainToDtoConverter;
import com.gmail.olgabovkaniuk.domain.Director;
import com.gmail.olgabovkaniuk.dto.FilmDto;
import com.gmail.olgabovkaniuk.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaService {

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    FilmDomainToDtoConverter filmDomainToDtoConverter;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.systemDefault());

    @Transactional
    public List<FilmDto> getFilmInfo(QueryParam queryParam) {
        Date from = convertToTimestamp(queryParam.getFromDate());
        Date to = convertToTimestamp(queryParam.getToDate());
        Long directorId = queryParam.getDirectorId();

        return cinemaRepository.getFilms(from, to, directorId).stream()
                .map(filmDomainToDtoConverter::convert)
                .collect(Collectors.toList());
    }

    public Date convertToTimestamp(String date) {
        if (date != null && date.length() > 0) {
            return Date.valueOf(String.valueOf(LocalDate.parse(date, DATE_TIME_FORMATTER)));
        }
        return null;
    }

    @Transactional
    public boolean isDirectorWithIdExist(Long directorId) {
        Director director = cinemaRepository.findDirectorById(directorId);
        if (director != null) {
            return true;
        }
        return false;
    }
}
