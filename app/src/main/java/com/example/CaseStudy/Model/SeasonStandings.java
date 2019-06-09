package com.example.CaseStudy.Model;

import java.util.List;

public class SeasonStandings {

    private Series series;

    private Season season;

    private List<Drivers> drivers;

    public void setSeries(Series series){
        this.series = series;
    }
    public Series getSeries(){
        return this.series;
    }
    public void setSeason(Season season){
        this.season = season;
    }
    public Season getSeason(){
        return this.season;
    }
    public void setDrivers(List<Drivers> drivers){
        this.drivers = drivers;
    }
    public List<Drivers> getDrivers(){
        return this.drivers;
    }

public class Series
{
    private String id;

    private String alias;

    private String name;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setAlias(String alias){
        this.alias = alias;
    }
    public String getAlias(){
        return this.alias;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}

public class Season
{
    private String id;

    private int year;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getYear(){
        return this.year;
    }
}

public class Drivers
{
    private String id;

    private String first_name;

    private String last_name;

    private String full_name;

    private String status;

    private int rank;

    private int points;

    private int starts;

    private int wins;

    private int poles;

    private int stage_wins;

    private int chase_bonus;

    private int chase_wins;

    private int chase_stage_wins;

    private int top_5;

    private int top_10;

    private int top_15;

    private int top_20;

    private int dnf;

    private int laps_led;

    private int laps_completed;

    private int money;

    private double avg_start_position;

    private double avg_finish_position;

    private double avg_laps_completed;

    private double laps_led_pct;

    private boolean in_chase;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }
    public String getFirst_name(){
        return this.first_name;
    }
    public void setLast_name(String last_name){
        this.last_name = last_name;
    }
    public String getLast_name(){
        return this.last_name;
    }
    public void setFull_name(String full_name){
        this.full_name = full_name;
    }
    public String getFull_name(){
        return this.full_name;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setRank(int rank){
        this.rank = rank;
    }
    public int getRank(){
        return this.rank;
    }
    public void setPoints(int points){
        this.points = points;
    }
    public int getPoints(){
        return this.points;
    }
    public void setStarts(int starts){
        this.starts = starts;
    }
    public int getStarts(){
        return this.starts;
    }
    public void setWins(int wins){
        this.wins = wins;
    }
    public int getWins(){
        return this.wins;
    }
    public void setPoles(int poles){
        this.poles = poles;
    }
    public int getPoles(){
        return this.poles;
    }
    public void setStage_wins(int stage_wins){
        this.stage_wins = stage_wins;
    }
    public int getStage_wins(){
        return this.stage_wins;
    }
    public void setChase_bonus(int chase_bonus){
        this.chase_bonus = chase_bonus;
    }
    public int getChase_bonus(){
        return this.chase_bonus;
    }
    public void setChase_wins(int chase_wins){
        this.chase_wins = chase_wins;
    }
    public int getChase_wins(){
        return this.chase_wins;
    }
    public void setChase_stage_wins(int chase_stage_wins){
        this.chase_stage_wins = chase_stage_wins;
    }
    public int getChase_stage_wins(){
        return this.chase_stage_wins;
    }
    public void setTop_5(int top_5){
        this.top_5 = top_5;
    }
    public int getTop_5(){
        return this.top_5;
    }
    public void setTop_10(int top_10){
        this.top_10 = top_10;
    }
    public int getTop_10(){
        return this.top_10;
    }
    public void setTop_15(int top_15){
        this.top_15 = top_15;
    }
    public int getTop_15(){
        return this.top_15;
    }
    public void setTop_20(int top_20){
        this.top_20 = top_20;
    }
    public int getTop_20(){
        return this.top_20;
    }
    public void setDnf(int dnf){
        this.dnf = dnf;
    }
    public int getDnf(){
        return this.dnf;
    }
    public void setLaps_led(int laps_led){
        this.laps_led = laps_led;
    }
    public int getLaps_led(){
        return this.laps_led;
    }
    public void setLaps_completed(int laps_completed){
        this.laps_completed = laps_completed;
    }
    public int getLaps_completed(){
        return this.laps_completed;
    }
    public void setMoney(int money){
        this.money = money;
    }
    public int getMoney(){
        return this.money;
    }
    public void setAvg_start_position(double avg_start_position){
        this.avg_start_position = avg_start_position;
    }
    public double getAvg_start_position(){
        return this.avg_start_position;
    }
    public void setAvg_finish_position(double avg_finish_position){
        this.avg_finish_position = avg_finish_position;
    }
    public double getAvg_finish_position(){
        return this.avg_finish_position;
    }
    public void setAvg_laps_completed(double avg_laps_completed){
        this.avg_laps_completed = avg_laps_completed;
    }
    public double getAvg_laps_completed(){
        return this.avg_laps_completed;
    }
    public void setLaps_led_pct(double laps_led_pct){
        this.laps_led_pct = laps_led_pct;
    }
    public double getLaps_led_pct(){
        return this.laps_led_pct;
    }
    public void setIn_chase(boolean in_chase){
        this.in_chase = in_chase;
    }
    public boolean getIn_chase(){
        return this.in_chase;
    }
}
}