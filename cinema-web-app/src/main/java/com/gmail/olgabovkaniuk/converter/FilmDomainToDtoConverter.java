package com.gmail.olgabovkaniuk.converter;

import com.gmail.olgabovkaniuk.domain.Film;
import com.gmail.olgabovkaniuk.dto.FilmDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class FilmDomainToDtoConverter implements Converter<Film, FilmDto> {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public FilmDto convert(Film film) {
        return new FilmDto(
                film.getName(),
                SIMPLE_DATE_FORMAT.format(film.getReleaseDate()),
                film.getGenre(),
                film.getDirector().getFirstName(),
                film.getDirector().getLastName(),
                SIMPLE_DATE_FORMAT.format(film.getDirector().getBirthDate())
        );
    }
}
