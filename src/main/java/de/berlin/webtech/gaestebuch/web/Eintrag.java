package de.berlin.webtech.gaestebuch.web;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Eintrag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private int restID;
    private double visitRating;
    private java.sql.Date publishDate;
    private String name;
    private String email;

    public Eintrag() {}

    public Eintrag(String text, int restID, double visitRating, String name, String email) {
        this.text = text;
        this.restID = restID;
        this.visitRating = visitRating;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getVisitRating() {
        return visitRating;
    }

    public void setVisitRating(double visitRating) {
        this.visitRating = visitRating;
    }

    public int getRestID() {
        return restID;
    }

    public void setRestID(int restID) {
        this.restID = restID;
    }
}
