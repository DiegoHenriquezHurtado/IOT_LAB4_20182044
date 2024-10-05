package com.example.telefutbol.Entity;

import java.io.Serializable;

public class Events implements Serializable {
    private String strLeague;
    private String strSeason;
    private String strHomeTeam;
    private String strAwayTeam;
    private String intHomeScore;
    private String intAwayScore;
    private String dateEvent;
    private String strLeagueBadge;
    private String intSpectators;

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrSeason() {
        return strSeason;
    }

    public void setStrSeason(String strSeason) {
        this.strSeason = strSeason;
    }

    public String getStrHomeTeam() {
        return strHomeTeam;
    }

    public void setStrHomeTeam(String strHomeTeam) {
        this.strHomeTeam = strHomeTeam;
    }

    public String getStrAwayTeam() {
        return strAwayTeam;
    }

    public void setStrAwayTeam(String strAwayTeam) {
        this.strAwayTeam = strAwayTeam;
    }

    public String getIntHomeScore() {
        return intHomeScore;
    }

    public void setIntHomeScore(String intHomeScore) {
        this.intHomeScore = intHomeScore;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getStrLeagueBadge() {
        return strLeagueBadge;
    }

    public void setStrLeagueBadge(String strLeagueBadge) {
        this.strLeagueBadge = strLeagueBadge;
    }

    public String getIntSpectators() {
        return intSpectators;
    }

    public void setIntSpectators(String intSpectators) {
        this.intSpectators = intSpectators;
    }

    public String getIntAwayScore() {
        return intAwayScore;
    }

    public void setIntAwayScore(String intAwayScore) {
        this.intAwayScore = intAwayScore;
    }
}
