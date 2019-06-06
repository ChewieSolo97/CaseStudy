package POJO.Classes;

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