package POJO.Classes;

public class TrackTypeSplits {

    private int starts;

    private int wins;

    private int top_5;

    private int top_10;

    private int poles;

    private int dnf;

    private int running_at_finish;

    private int lead_lap_finish;

    private int laps_completed;

    private int laps_led;

    private int money;

    private double avg_start_position;

    private double avg_finish_position;

    private double miles_completed;

    private String track_type;

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
    public void setPoles(int poles){
        this.poles = poles;
    }
    public int getPoles(){
        return this.poles;
    }
    public void setDnf(int dnf){
        this.dnf = dnf;
    }
    public int getDnf(){
        return this.dnf;
    }
    public void setRunning_at_finish(int running_at_finish){
        this.running_at_finish = running_at_finish;
    }
    public int getRunning_at_finish(){
        return this.running_at_finish;
    }
    public void setLead_lap_finish(int lead_lap_finish){
        this.lead_lap_finish = lead_lap_finish;
    }
    public int getLead_lap_finish(){
        return this.lead_lap_finish;
    }
    public void setLaps_completed(int laps_completed){
        this.laps_completed = laps_completed;
    }
    public int getLaps_completed(){
        return this.laps_completed;
    }
    public void setLaps_led(int laps_led){
        this.laps_led = laps_led;
    }
    public int getLaps_led(){
        return this.laps_led;
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
    public void setMiles_completed(double miles_completed){
        this.miles_completed = miles_completed;
    }
    public double getMiles_completed(){
        return this.miles_completed;
    }
    public void setTrack_type(String track_type){
        this.track_type = track_type;
    }
    public String getTrack_type(){
        return this.track_type;
    }
}