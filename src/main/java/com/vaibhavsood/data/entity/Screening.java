package com.vaibhavsood.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "SCREENING")
public class Screening {
    @Id
    @Column(name = "SCREENING_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long screeningId;
    @Column(name = "THEATRE_ID")
    private long theatreId;
    @Column(name = "SCREEN_ID")
    private long screenId;
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Column(name = "SCREENING_DATE")
    private String screeningDate;
    @Column(name = "SCREENING_TIME")
    private String screeningTime;

    public long getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(long screeningId) {
        this.screeningId = screeningId;
    }

    public long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(long theatreId) {
        this.theatreId = theatreId;
    }

    public long getScreenId() {
        return screenId;
    }

    public void setScreenId(long screenId) {
        this.screenId = screenId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getScreeningDate() {
        return screeningDate;
    }

    public void setScreeningDate(String screeningDate) {
        this.screeningDate = screeningDate;
    }

    public String getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(String screeningTime) {
        this.screeningTime = screeningTime;
    }
}
