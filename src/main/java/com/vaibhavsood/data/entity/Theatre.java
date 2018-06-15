package com.vaibhavsood.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "THEATRE")
public class Theatre {
    @Id
    @Column(name = "THEATRE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "THEATRE_NAME")
    private String name;
    @Column(name = "THEATRE_CITY")
    private String city;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
