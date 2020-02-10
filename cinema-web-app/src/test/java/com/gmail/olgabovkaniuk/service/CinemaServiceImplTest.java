package com.gmail.olgabovkaniuk.service;

import com.gmail.olgabovkaniuk.controller.QueryParam;
import com.gmail.olgabovkaniuk.converter.FilmDomainToDtoConverter;
import com.gmail.olgabovkaniuk.domain.Director;
import com.gmail.olgabovkaniuk.domain.Film;
import com.gmail.olgabovkaniuk.dto.FilmDto;
import com.gmail.olgabovkaniuk.repository.CinemaRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CinemaServiceImplTest {

    @InjectMocks
    CinemaServiceImpl cinemaServiceImpl;

    @Mock
    CinemaRepositoryImpl cinemaRepositoryImpl;

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    FilmDomainToDtoConverter filmDomainToDtoConverter;

    @Test
    public void getFilmInfoTest() {
        //given
        List<Film> filmList = new ArrayList<>();
        Director director = new Director();
        director.setId(1L);
        director.setFirstName("David");
        director.setLastName("Smith");
        director.setBirthDate(Date.valueOf("1975-10-15"));
        director.setFilmList(filmList);
        Film film1 = new Film(
                "Ace age",
                Date.valueOf("2019-09-12"),
                "cartoon",
                director
        );
        Film film2 = new Film(
                "Ace age2",
                Date.valueOf("2020-10-25"),
                "cartoon",
                director
        );
        Film film3 = new Film(
                "Race",
                Date.valueOf("2021-03-27"),
                "cartoon",
                director
        );

        filmList.add(film1);
        filmList.add(film2);
        filmList.add(film3);

        when(cinemaRepositoryImpl.getFilms(null, null, null)).thenReturn(filmList);

        //when
        List<FilmDto> filmDtoList = cinemaServiceImpl.getFilmInfo(new QueryParam());

        //then
        assertEquals(3, filmDtoList.size());
        verify(cinemaRepositoryImpl, times(1)).getFilms(null, null, null);
    }

    @Test
    public void isDirectorWithIdExistTest() {
        //given
        List<Film> filmList = new ArrayList<>();
        Director director = new Director();
        director.setId(1L);
        director.setFirstName("David");
        director.setLastName("Smith");
        director.setBirthDate(Date.valueOf("1975-10-15"));
        director.setFilmList(filmList);

        when(cinemaRepositoryImpl.findDirectorById(1L)).thenReturn(director);

        //when
        boolean directorWithIdExist = cinemaServiceImpl.isDirectorWithIdExist(1L);

        //then
        Assert.assertTrue(directorWithIdExist);
    }
}