package POJO.Classes;

import java.util.List;

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

