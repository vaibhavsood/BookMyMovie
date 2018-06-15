package com.vaibhavsood.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "SCREEN")
public class Screen {
    @Id
    @Column(name = "SCREEN_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long screen_id;
    @Column(name = "THEATRE_ID")
    private long theatre_id;
    @Column(name = "SEATS_NUM")
    private int seats_num;

    public long getScreen_id() {
        return screen_id;
    }

    public void setScreen_id(long screen_id) {
        this.screen_id = screen_id;
    }

    public long getTheatre_id() {
        return theatre_id;
    }

    public void setTheatre_id(long theatre_id) {
        this.theatre_id = theatre_id;
    }

    public int getSeats_num() {
        return seats_num;
    }

    public void setSeats_num(int seats_num) {
        this.seats_num = seats_num;
    }
}
