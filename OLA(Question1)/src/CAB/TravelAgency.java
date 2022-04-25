package CAB;

public class TravelAgency {
    String name,phone;
   public TravelAgency(String cab,String phone){
        this.name = cab;
        this.phone = phone;
   }
   public void print(){
       System.out.println("Travels name : "+name + "\t\tTravel Agency Phone number : "+phone);

   }
}
