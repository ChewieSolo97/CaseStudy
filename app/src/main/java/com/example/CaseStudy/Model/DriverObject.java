package com.example.CaseStudy.Model;

// this will represent a driver from the driver table in localdb

public class DriverObject {

    private String name;
    private int height;
    private String birthday;
    private int rookieYear;
    private String residence;
    private String birthplace;
    private String team;
    private String crewchief;
    private String number;
    private int starts;
    private int wins;
    private int top5s;
    private int top10s;
    private int poles;
    private int dnf;
    private int lapsled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getRookieYear() {
        return rookieYear;
    }

    public void setRookieYear(int rookieYear) {
        this.rookieYear = rookieYear;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCrewchief() {
        return crewchief;
    }

    public void setCrewchief(String crewchief) {
        this.crewchief = crewchief;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        // to make them all the same length for consistency
        if (number.length() == 1) {
            number = "0" + number;
        }
        this.number = number;
    }

    public int getStarts() {
        return starts;
    }

    public void setStarts(int starts) {
        this.starts = starts;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getTop5s() {
        return top5s;
    }

    public void setTop5s(int top5s) {
        this.top5s = top5s;
    }

    public int getTop10s() {
        return top10s;
    }

    public void setTop10s(int top10s) {
        this.top10s = top10s;
    }

    public int getPoles() {
        return poles;
    }

    public void setPoles(int poles) {
        this.poles = poles;
    }

    public int getDnf() {
        return dnf;
    }

    public void setDnf(int dnf) {
        this.dnf = dnf;
    }

    public int getLapsled() {
        return lapsled;
    }

    public void setLapsled(int lapsled) {
        this.lapsled = lapsled;
    }
}
