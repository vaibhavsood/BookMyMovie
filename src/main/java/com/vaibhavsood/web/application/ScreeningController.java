package com.vaibhavsood.web.application;

import com.vaibhavsood.business.domain.MovieScreening;
import com.vaibhavsood.business.service.ScreeningService;
import com.vaibhavsood.data.entity.Screening;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/screenings")
public class ScreeningController {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ScreeningService screeningService;

    @RequestMapping(method = RequestMethod.GET)
    public String getScreenings(@RequestParam(value = "date", required = false)String dateString, Model model) {
        Date date = null;
        if (dateString != null) {
            try {
                date = DATE_FORMAT.parse(dateString);

            } catch (ParseException pe) {
                date = new Date();
            }
        } else {
            date = new Date();
        }

        List<MovieScreening> result = this.screeningService.getMovieScreeningsByDate(date);
        model.addAttribute("movieScreenings", result);

        return "screenings";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String bookSeats(@ModelAttribute MovieScreening movieScreening) {
        LOGGER.info("movieName:" + movieScreening.getMovieName());
        LOGGER.info(movieScreening.getTheatreCity());
        LOGGER.info(movieScreening.getTheatreName());
        //LOGGER.info(movieScreening.getScreeningTime());
        return "result";
    }

}
