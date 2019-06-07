package POJO.Classes;

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
