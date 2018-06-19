package com.vaibhavsood.business.service;

import com.vaibhavsood.business.domain.MovieScreening;
import com.vaibhavsood.data.entity.Screening;
import com.vaibhavsood.data.entity.Theatre;
import com.vaibhavsood.data.repository.MovieRepository;
import com.vaibhavsood.data.repository.ScreeningRepository;
import com.vaibhavsood.data.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScreeningService {
    private ScreeningRepository screeningRepository;
    private MovieRepository movieRepository;
    private TheatreRepository theatreRepository;

    public ScreeningService(ScreeningRepository screeningRepository, MovieRepository movieRepository, TheatreRepository theatreRepository) {
        this.screeningRepository = screeningRepository;
        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
    }

    public List<MovieScreening> getMovieScreeningsByDate(Date date) {
        Iterable<Screening> screenings = this.screeningRepository.findByScreeningDate(new java.sql.Date(date.getTime()));
        List<MovieScreening> movieScreenings = new ArrayList<>();

        if (screenings != null) {
            for (Screening screening : screenings) {
                MovieScreening movieScreening = new MovieScreening();
                Theatre theatre = theatreRepository.findByTheatreId(screening.getTheatreId());

                movieScreening.setMovieName(screening.getMovieName());

                if (theatre != null) {
                    movieScreening.setTheatreId(theatre.getTheatreId());
                    movieScreening.setTheatreName(theatre.getTheatreName());
                    movieScreening.setTheatreCity(theatre.getTheatreCity());
                }

                movieScreening.setScreeningTime(screening.getScreeningTime());

                movieScreenings.add(movieScreening);
            }
        }

        return movieScreenings;
    }
}
