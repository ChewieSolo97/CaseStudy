package POJO.Classes;

public class Cars
{
    private String id;

    private String number;

    private String sponsors;

    private String status;

    private String crew_chief;

    private Manufacturer manufacturer;

    private Engine engine;

    private Owner owner;

    private Team team;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
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
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setCrew_chief(String crew_chief){
        this.crew_chief = crew_chief;
    }
    public String getCrew_chief(){
        return this.crew_chief;
    }
    public void setManufacturer(Manufacturer manufacturer){
        this.manufacturer = manufacturer;
    }
    public Manufacturer getManufacturer(){
        return this.manufacturer;
    }
    public void setEngine(Engine engine){
        this.engine = engine;
    }
    public Engine getEngine(){
        return this.engine;
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