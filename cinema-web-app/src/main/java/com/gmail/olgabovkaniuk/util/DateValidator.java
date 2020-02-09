package com.gmail.olgabovkaniuk.util;

import com.gmail.olgabovkaniuk.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DateValidator {

    private static Logger log = Logger.getLogger("DateValidator");

    @Autowired
    CinemaService cinemaService;

    public boolean isValid(final String date) {
        try {
            cinemaService.convertToTimestamp(date);
        } catch (Exception e) {
            log.severe(e.getMessage());
            return false;
        }
        return true;
    }
}
