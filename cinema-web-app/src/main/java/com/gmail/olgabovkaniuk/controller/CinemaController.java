package com.gmail.olgabovkaniuk.controller;

import com.gmail.olgabovkaniuk.dto.FilmDto;
import com.gmail.olgabovkaniuk.service.CinemaService;
import com.gmail.olgabovkaniuk.service.QueryParamValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cinema-information")
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

    @Autowired
    QueryParamValidator queryParamValidator;

    @GetMapping
    public ModelAndView cinemaInformation(Model model) {
        ModelAndView view = new ModelAndView("cinemainformation", "queryParam", new QueryParam());
        return view;
    }

    @GetMapping("/overview")
    public String getRowByPeriodInformation(@Validated @ModelAttribute("queryParam") QueryParam queryParam, BindingResult bindingResult, Model model) {
        queryParamValidator.validate(queryParam, bindingResult);
        if (bindingResult.hasErrors()) {
            return "cinemainformation";
        }
        List<FilmDto> filmDtoList = cinemaService.getFilmInfo(queryParam);
        model.addAttribute("film_list", filmDtoList);
        return "overviewpage";
    }
}
