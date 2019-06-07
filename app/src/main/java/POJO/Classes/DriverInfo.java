package POJO.Classes;

import java.util.List;

public class DriverInfo {

    private Series series;

    private Season season;

    private List<OtherDrivers> drivers;

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
    public void setDrivers(List<OtherDrivers> drivers){
        this.drivers = drivers;
    }
    public List<OtherDrivers> getDrivers(){
        return this.drivers;
    }
}
