package com.example.CaseStudy.Model;

import java.util.List;

public class Schedule {

    private Series series;

    private Season season;

    private List<Events> events;

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
    public void setEvents(List<Events> events){
        this.events = events;
    }
    public List<Events> getEvents(){
        return this.events;
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


public class Track
{
    private String name;

    private String market;

    private int completed;

    private double distance;

    private String shape;

    private String banking;

    private int frontstretch;

    private int backstretch;

    private String address;

    private String city;

    private String state;

    private String zip;

    private String country;

    private String surface;

    private String track_type;

    private String owner;

    private String id;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setMarket(String market){
        this.market = market;
    }
    public String getMarket(){
        return this.market;
    }
    public void setCompleted(int completed){
        this.completed = completed;
    }
    public int getCompleted(){
        return this.completed;
    }
    public void setDistance(double distance){
        this.distance = distance;
    }
    public double getDistance(){
        return this.distance;
    }
    public void setShape(String shape){
        this.shape = shape;
    }
    public String getShape(){
        return this.shape;
    }
    public void setBanking(String banking){
        this.banking = banking;
    }
    public String getBanking(){
        return this.banking;
    }
    public void setFrontstretch(int frontstretch){
        this.frontstretch = frontstretch;
    }
    public int getFrontstretch(){
        return this.frontstretch;
    }
    public void setBackstretch(int backstretch){
        this.backstretch = backstretch;
    }
    public int getBackstretch(){
        return this.backstretch;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }
    public void setState(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }
    public void setZip(String zip){
        this.zip = zip;
    }
    public String getZip(){
        return this.zip;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setSurface(String surface){
        this.surface = surface;
    }
    public String getSurface(){
        return this.surface;
    }
    public void setTrack_type(String track_type){
        this.track_type = track_type;
    }
    public String getTrack_type(){
        return this.track_type;
    }
    public void setOwner(String owner){
        this.owner = owner;
    }
    public String getOwner(){
        return this.owner;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
}


public class Broadcast
{
    private String network;

    private String satellite;

    private String radio;

    public void setNetwork(String network){
        this.network = network;
    }
    public String getNetwork(){
        return this.network;
    }
    public void setSatellite(String satellite){
        this.satellite = satellite;
    }
    public String getSatellite(){
        return this.satellite;
    }
    public void setRadio(String radio){
        this.radio = radio;
    }
    public String getRadio(){
        return this.radio;
    }
}


public class Prior_winner
{
    private String first_name;

    private String last_name;

    private String full_name;

    private String id;

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
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
}


public class Races
{
    private String id;

    private String name;

    private String status;

    private int distance;

    private int laps;

    private boolean chase_race;

    private String scheduled;

    private String start_time;

    private String end_time;

    private Broadcast broadcast;

    private Prior_winner prior_winner;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setDistance(int distance){
        this.distance = distance;
    }
    public int getDistance(){
        return this.distance;
    }
    public void setLaps(int laps){
        this.laps = laps;
    }
    public int getLaps(){
        return this.laps;
    }
    public void setChase_race(boolean chase_race){
        this.chase_race = chase_race;
    }
    public boolean getChase_race(){
        return this.chase_race;
    }
    public void setScheduled(String scheduled){
        this.scheduled = scheduled;
    }
    public String getScheduled(){
        return this.scheduled;
    }
    public void setStart_time(String start_time){
        this.start_time = start_time;
    }
    public String getStart_time(){
        return this.start_time;
    }
    public void setEnd_time(String end_time){
        this.end_time = end_time;
    }
    public String getEnd_time(){
        return this.end_time;
    }
    public void setBroadcast(Broadcast broadcast){
        this.broadcast = broadcast;
    }
    public Broadcast getBroadcast(){
        return this.broadcast;
    }
    public void setPrior_winner(Prior_winner prior_winner){
        this.prior_winner = prior_winner;
    }
    public Prior_winner getPrior_winner(){
        return this.prior_winner;
    }
}


public class Events
{
    private String id;

    private String name;

    private String start_date;

    private Track track;

    private List<Races> races;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setStart_date(String start_date){
        this.start_date = start_date;
    }
    public String getStart_date(){
        return this.start_date;
    }
    public void setTrack(Track track){
        this.track = track;
    }
    public Track getTrack(){
        return this.track;
    }
    public void setRaces(List<Races> races){
        this.races = races;
    }
    public List<Races> getRaces(){
        return this.races;
    }
}

}
