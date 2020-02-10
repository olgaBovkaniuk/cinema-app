package com.gmail.olgabovkaniuk.service;

import com.gmail.olgabovkaniuk.controller.QueryParam;
import com.gmail.olgabovkaniuk.util.DateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class QueryParamValidator implements Validator {

    @Autowired
    CinemaServiceImpl cinemaServiceImpl;

    @Autowired
    DateValidator dateValidator;

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        QueryParam queryParam = (QueryParam) target;
        if (!queryParam.getFromDate().equals("")) {
            if (!dateValidator.isValid(queryParam.getFromDate())) {
                errors.rejectValue("fromDate", "field.required",
                        "Please, provide correct date in format 'dd/mm/yyyy'");
            }
        }
        if (!queryParam.getToDate().equals("")) {
            if (!dateValidator.isValid(queryParam.getToDate())) {
                errors.rejectValue("toDate", "field.required",
                        "Please, provide correct date in format 'dd/mm/yyyy'");
            }
        }
        if (queryParam.getDirectorId() != null) {
            if (!cinemaServiceImpl.isDirectorWithIdExist(queryParam.getDirectorId())) {
                errors.rejectValue("directorId", "field.required",
                        "Director with ID: " + queryParam.getDirectorId() + " does not exist!");
            }
        }
    }
}
