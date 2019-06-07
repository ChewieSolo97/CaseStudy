package POJO.Classes;

import java.util.List;

public class Qualify {
    private String id;

    private String name;

    private String status;

    private String condition;

    private int number;

    private int distance;

    private int laps;

    private int purse;

    private boolean restrictor_plate;

    private String scheduled;

    private Track track;

    private List<Qualifying> qualifying;

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
    public void setCondition(String condition){
        this.condition = condition;
    }
    public String getCondition(){
        return this.condition;
    }
    public void setNumber(int number){
        this.number = number;
    }
    public int getNumber(){
        return this.number;
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
    public void setPurse(int purse){
        this.purse = purse;
    }
    public int getPurse(){
        return this.purse;
    }
    public void setRestrictor_plate(boolean restrictor_plate){
        this.restrictor_plate = restrictor_plate;
    }
    public boolean getRestrictor_plate(){
        return this.restrictor_plate;
    }
    public void setScheduled(String scheduled){
        this.scheduled = scheduled;
    }
    public String getScheduled(){
        return this.scheduled;
    }
    public void setTrack(Track track){
        this.track = track;
    }
    public Track getTrack(){
        return this.track;
    }
    public void setQualifying(List<Qualifying> qualifying){
        this.qualifying = qualifying;
    }
    public List<Qualifying> getQualifying(){
        return this.qualifying;
    }
public class Track
{
    private String name;

    private double distance;

    private String shape;

    private String banking;

    private int frontstretch;

    private int backstretch;

    private int seating;

    private String id;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
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
    public void setSeating(int seating){
        this.seating = seating;
    }
    public int getSeating(){
        return this.seating;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
}


public class Manufacturer
{
    private String id;

    private String name;

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
}


public class Owner
{
    private String id;

    private String name;

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
}


public class Team
{
    private String id;

    private String name;

    private Owner owner;

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
    public void setOwner(Owner owner){
        this.owner = owner;
    }
    public Owner getOwner(){
        return this.owner;
    }
}


public class Car
{
    private String number;

    private String sponsors;

    private String crew_chief;

    private String id;

    private Manufacturer manufacturer;

    private Owner owner;

    private Team team;

    public void setNumber(String number){
        this.number = number;
    }
    public String getNumber(){
        return this.number;
    }
    public void setSponsors(String sponsors){
        this.sponsors = sponsors;
    }
    public String getSponsors(){
        return this.sponsors;
    }
    public void setCrew_chief(String crew_chief){
        this.crew_chief = crew_chief;
    }
    public String getCrew_chief(){
        return this.crew_chief;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setManufacturer(Manufacturer manufacturer){
        this.manufacturer = manufacturer;
    }
    public Manufacturer getManufacturer(){
        return this.manufacturer;
    }
    public void setOwner(Owner owner){
        this.owner = owner;
    }
    public Owner getOwner(){
        return this.owner;
    }
    public void setTeam(Team team){
        this.team = team;
    }
    public Team getTeam(){
        return this.team;
    }
}


public class Driver
{
    private String first_name;

    private String last_name;

    private String full_name;

    private boolean points_eligible;

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
    public void setPoints_eligible(boolean points_eligible){
        this.points_eligible = points_eligible;
    }
    public boolean getPoints_eligible(){
        return this.points_eligible;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
}


public class Rounds
{
    private int sequence;

    private int position;

    private double speed;

    private double lap_time;

    private int laps_completed;

    private int best_lap;

    private double last_lap_time;

    public void setSequence(int sequence){
        this.sequence = sequence;
    }
    public int getSequence(){
        return this.sequence;
    }
    public void setPosition(int position){
        this.position = position;
    }
    public int getPosition(){
        return this.position;
    }
    public void setSpeed(double speed){
        this.speed = speed;
    }
    public double getSpeed(){
        return this.speed;
    }
    public void setLap_time(double lap_time){
        this.lap_time = lap_time;
    }
    public double getLap_time(){
        return this.lap_time;
    }
    public void setLaps_completed(int laps_completed){
        this.laps_completed = laps_completed;
    }
    public int getLaps_completed(){
        return this.laps_completed;
    }
    public void setBest_lap(int best_lap){
        this.best_lap = best_lap;
    }
    public int getBest_lap(){
        return this.best_lap;
    }
    public void setLast_lap_time(double last_lap_time){
        this.last_lap_time = last_lap_time;
    }
    public double getLast_lap_time(){
        return this.last_lap_time;
    }
}


public class Qualifying
{
    private int position;

    private String status;

    private Car car;

    private Driver driver;

    private List<Rounds> rounds;

    public void setPosition(int position){
        this.position = position;
    }
    public int getPosition(){
        return this.position;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setCar(Car car){
        this.car = car;
    }
    public Car getCar(){
        return this.car;
    }
    public void setDriver(Driver driver){
        this.driver = driver;
    }
    public Driver getDriver(){
        return this.driver;
    }
    public void setRounds(List<Rounds> rounds){
        this.rounds = rounds;
    }
    public List<Rounds> getRounds(){
        return this.rounds;
    }
}

}
