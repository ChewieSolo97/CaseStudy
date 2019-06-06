package POJO.Classes;

import java.util.ArrayList;
import java.util.List;

public class Drivers
{
    private Series series;

    private Season season;

    private List<Driver> drivers;

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
    public void setDrivers(List<Driver> drivers){
        this.drivers = drivers;
    }
    public List<Driver> getDrivers(){
        return this.drivers;
    }
}

