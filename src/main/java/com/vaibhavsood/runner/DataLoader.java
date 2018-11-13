package com.vaibhavsood.runner;

import com.vaibhavsood.data.entity.Movie;
import com.vaibhavsood.data.repository.MovieRepository;
import com.vaibhavsood.data.repository.ScreeningRepository;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class DataLoader implements ApplicationRunner {
    private MovieRepository movieRepository;

    public MovieRepository getMovieRepository() {
        return movieRepository;
    }

    public ScreeningRepository getScreeningRepository() {
        return screeningRepository;
    }

    private ScreeningRepository screeningRepository;

    @Autowired
    public DataLoader(MovieRepository movieRepository, ScreeningRepository screeningRepository) {
        this.movieRepository = movieRepository;
        this.screeningRepository = screeningRepository;
    }

    private void populateMovieTable() {
        try (BufferedReader brMovies = new BufferedReader(new FileReader("C:\\Users\\vaibhav_sood.PERSISTENT\\Downloads\\Ex_Files_Learning_Spring_Boot\\Ex_Files_Learning_Spring_Boot\\Exercise Files\\Chapter 1\\01_03\\01_03_end\\reservations\\src\\main\\resources\\movies.csv"));
             BufferedReader brLinks = new BufferedReader(new FileReader("C:\\Users\\vaibhav_sood.PERSISTENT\\Downloads\\Ex_Files_Learning_Spring_Boot\\Ex_Files_Learning_Spring_Boot\\Exercise Files\\Chapter 1\\01_03\\01_03_end\\reservations\\src\\main\\resources\\links.csv"))) {
            String line;
            brMovies.readLine();    // Skip header line
            brLinks.readLine();     // Skip header line
            while ((line = brMovies.readLine()) != null) {
                String[] movieLine = line.split(",");

                String movieName = "";

                for (int i = 1; i < movieLine.length-1; i++) {
                    if (i == movieLine.length-2)
                        movieName += movieLine[i];
                    else
                        movieName += movieLine[i] + ",";
                }

                Movie movie = new Movie();
                movie.setMovieId(movieLine[0]);
                movie.setMovieName(movieName.substring(0, movieName.indexOf('(')).trim());

                String line1 = brLinks.readLine();
                String[] linkLine = line1.split(",");
                Document movieLensPage;
                try {
                    movieLensPage = Jsoup.connect("https://www.imdb.com/title/tt" + linkLine[1]).get();
                } catch (HttpStatusException e) {
                    continue;
                }
                Element image = movieLensPage.getElementsByClass("poster").first().children().first().children().first();
                movie.setMoviePosterUrl(image.attr("src"));

                movieRepository.save(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void populateScreeningsTable() {

    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        populateMovieTable();
        populateScreeningsTable();
    }
}
