package com.example.telefutbol.Entity;

import java.io.Serializable;

public class Table implements Serializable {
    private String strTeam;
    private String intRank;
    private String strBadge;
    private String intWin;
    private String intLoss;
    private String intDraw;
    private String intGoalsFor;
    private String intGoalsAgainst;
    private String intGoalDifference;

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getIntRank() {
        return intRank;
    }

    public void setIntRank(String intRank) {
        this.intRank = intRank;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public void setStrBadge(String strBadge) {
        this.strBadge = strBadge;
    }

    public String getIntWin() {
        return intWin;
    }

    public void setIntWin(String intWin) {
        this.intWin = intWin;
    }

    public String getIntLoss() {
        return intLoss;
    }

    public void setIntLoss(String intLoss) {
        this.intLoss = intLoss;
    }

    public String getIntDraw() {
        return intDraw;
    }

    public void setIntDraw(String intDraw) {
        this.intDraw = intDraw;
    }

    public String getIntGoalsFor() {
        return intGoalsFor;
    }

    public void setIntGoalsFor(String intGoalsFor) {
        this.intGoalsFor = intGoalsFor;
    }

    public String getIntGoalsAgainst() {
        return intGoalsAgainst;
    }

    public void setIntGoalsAgainst(String intGoalsAgainst) {
        this.intGoalsAgainst = intGoalsAgainst;
    }

    public String getIntGoalDifference() {
        return intGoalDifference;
    }

    public void setIntGoalDifference(String intGoalDifference) {
        this.intGoalDifference = intGoalDifference;
    }
}
