package com.vaibhavsood.business.service;

import com.vaibhavsood.business.domain.MovieScreening;
import com.vaibhavsood.data.entity.*;
import com.vaibhavsood.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ScreeningService {
    private ScreeningRepository screeningRepository;
    private MovieRepository movieRepository;
    private TheatreRepository theatreRepository;
    private TicketRepository ticketRepository;
    private ScreenRepository screenRepository;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public ScreeningService(ScreeningRepository screeningRepository, MovieRepository movieRepository, TheatreRepository theatreRepository
                            , TicketRepository ticketRepository, ScreenRepository screenRepository) {
        this.screeningRepository = screeningRepository;
        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
        this.ticketRepository = ticketRepository;
        this.screenRepository = screenRepository;
    }

    private Screening getScreening(MovieScreening movieScreening) {
        Theatre theatre = theatreRepository.findByTheatreNameAndTheatreCity(movieScreening.getTheatreName(), movieScreening.getTheatreCity());
        if (theatre == null)
            return null;
        return screeningRepository.findByMovieNameAndTheatreIdAndScreeningDateAndScreeningTime(movieScreening.getMovieName(), theatre.getTheatreId(),
                java.sql.Date.valueOf(movieScreening.getScreeningDate()), java.sql.Time.valueOf(movieScreening.getScreeningTime()));
    }

    public int bookSeats(MovieScreening movieScreening, int seats) {
        Screening screening = getScreening(movieScreening);
        screening.setBookedTickets(seats);
        screeningRepository.save(screening);
        return getBookedSeats(movieScreening);
    }

    public int getBookedSeats(MovieScreening movieScreening) {
        Screening screening = getScreening(movieScreening);
        return screening.getBookedTickets();
    }

    public int getTotalSeats(MovieScreening movieScreening) {
        Screening screening = getScreening(movieScreening);
        long screenId = screening.getScreenId();
        return screenRepository.findByScreenId(screenId).getSeatsNum();
    }

    public Set<Movie> getMoviesByDate(Date date) {
        Iterable<Screening> screenings = this.screeningRepository.findByScreeningDate(new java.sql.Date(date.getTime()));
        Set<Movie> movies = new HashSet<>();

        if (screenings != null) {
            for (Screening screening : screenings) {
                Movie movie = movieRepository.findByMovieName(screening.getMovieName());
                movies.add(movie);
            }
        }

        return movies;
    }

    public List<Screening> getScreeningsByMovie(String movieName) {
        return this.screeningRepository.findByMovieName(movieName);
    }

    public List<MovieScreening> getMovieScreeningsByMovie(String movieName) {
        Iterable<Screening> screenings = this.screeningRepository.findByMovieName(movieName);
        List<MovieScreening> movieScreenings = new ArrayList<>();

        if (screenings != null) {
            for (Screening screening : screenings) {
                MovieScreening movieScreening = new MovieScreening();
                Theatre theatre = theatreRepository.findByTheatreId(screening.getTheatreId());
                Movie movie = movieRepository.findByMovieName(screening.getMovieName());

                movieScreening.setMovieName(screening.getMovieName());
                movieScreening.setMoviePosterURL(movie.getMoviePosterUrl());

                if (theatre != null) {
                    movieScreening.setTheatreId(theatre.getTheatreId());
                    movieScreening.setTheatreName(theatre.getTheatreName());
                    movieScreening.setTheatreCity(theatre.getTheatreCity());
                }


                movieScreening.setScreeningDate(screening.getScreeningDate().toString());
                movieScreening.setScreeningTime(screening.getScreeningTime().toString());

                movieScreenings.add(movieScreening);
            }
        }

        return movieScreenings;
    }
}
