package SERVICES;

public class Driver extends Car{
    public String Dname,Dnum,avail;
    public Driver(String vehicle, String type,String Dname,String Dnum) {
        super(vehicle, type);
        this.Dname = Dname;
        this.Dnum = Dnum;
        avail = super.avail;
    }
    public void print(){
        System.out.println("Driver name : "+Dname + "\t\tDriver num : "+Dnum);
    }
}
