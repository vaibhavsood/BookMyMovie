package com.vaibhavsood.web.application;

import com.vaibhavsood.business.domain.MovieScreening;
import com.vaibhavsood.business.service.ScreeningService;
import com.vaibhavsood.data.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/seats")
public class SeatsController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(method = RequestMethod.GET)
    public String bookSeats(@RequestParam(value = "count", required = true)int seatCount, Model model) {
        model.addAttribute("count", seatCount);
        return "seats";
    }
}
