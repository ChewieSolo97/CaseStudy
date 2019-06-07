package POJO.Classes;

public class Broadcast
{
    private String network;

    private String satellite;

    private String radio;

    public void setNetwork(String network){
        this.network = network;
    }
    public String getNetwork(){
        return this.network;
    }
    public void setSatellite(String satellite){
        this.satellite = satellite;
    }
    public String getSatellite(){
        return this.satellite;
    }
    public void setRadio(String radio){
        this.radio = radio;
    }
    public String getRadio(){
        return this.radio;
    }
}