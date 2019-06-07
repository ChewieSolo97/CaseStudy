package POJO.Classes;

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
}
