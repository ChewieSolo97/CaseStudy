package POJO.Classes;

import java.util.ArrayList;
import java.util.List;
public class Driver
{
    private String id;

    private String first_name;

    private String last_name;

    private String full_name;

    private int height;

    private String birthday;

    private int rookie_year;

    private String gender;

    private String status;

    private String country;

    private String residence;

    private String birth_place;

    private String twitter;

    private boolean points_eligible;

    private Team team;

    private List<Cars> cars;

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
    public void setHeight(int height){
        this.height = height;
    }
    public int getHeight(){
        return this.height;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public String getBirthday(){
        return this.birthday;
    }
    public void setRookie_year(int rookie_year){
        this.rookie_year = rookie_year;
    }
    public int getRookie_year(){
        return this.rookie_year;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setResidence(String residence){
        this.residence = residence;
    }
    public String getResidence(){
        return this.residence;
    }
    public void setBirth_place(String birth_place){
        this.birth_place = birth_place;
    }
    public String getBirth_place(){
        return this.birth_place;
    }
    public void setTwitter(String twitter){
        this.twitter = twitter;
    }
    public String getTwitter(){
        return this.twitter;
    }
    public void setPoints_eligible(boolean points_eligible){
        this.points_eligible = points_eligible;
    }
    public boolean getPoints_eligible(){
        return this.points_eligible;
    }
    public void setTeam(Team team){
        this.team = team;
    }
    public Team getTeam(){
        return this.team;
    }
    public void setCars(List<Cars> cars){
        this.cars = cars;
    }
    public List<Cars> getCars(){
        return this.cars;
    }
}