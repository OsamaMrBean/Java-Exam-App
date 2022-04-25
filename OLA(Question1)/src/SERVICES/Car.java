package SERVICES;

public class Car extends Service{
    public String vehicle,type,avail;
    Car(String vehicle,String type){
        this.avail = "Y";
        this.type = type;
        this.vehicle = vehicle;
    }
}
