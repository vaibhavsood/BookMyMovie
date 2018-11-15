package com.vaibhavsood.data.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "SCREENING")
public class Screening implements Cloneable {
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
    private java.sql.Date screeningDate;
    @Column(name = "SCREENING_TIME")
    private java.sql.Time screeningTime;
    @Column(name = "BOOKED_TICKETS")
    private int bookedTickets;

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public int getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(int bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

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

    public Date getScreeningDate() {
        return screeningDate;
    }

    public void setScreeningDate(Date screeningDate) {
        this.screeningDate = screeningDate;
    }

    public Time getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(Time screeningTime) {
        this.screeningTime = screeningTime;
    }
}
