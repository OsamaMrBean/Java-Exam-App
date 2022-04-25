package VEHICLE_BOOKING;

public class Trip extends Booking{
    public String TripId,bookingId,dnum;
    public double amount=0,tamount,discount=0,adtnl=0;
    public int shour,smin,ehour,emin;
    public void calc(int starthour, int startmin,int rate){
        if(((shour - starthour) > 0 && (shour - starthour)<8) || (smin - startmin) > 15 ){
            discount = 1;
            amount = ((ehour - shour) + (emin - smin)/60) * rate;
            tamount = amount - (amount * discount/100);
        if((shour - ehour) > 8 )
            adtnl = 100;
            amount = ((ehour - shour) + (emin - smin)/60) * rate;
            tamount = amount - adtnl*(ehour - shour);
        }
        if ((shour>8 && ehour<10) || (shour>17 && ehour<20)){
            double r = rate * 1.5;
            amount = ((ehour - shour) + (emin - smin)/60) * r;
            tamount = amount;
        }
        else{
            amount = ((ehour - shour) + (emin - smin)/60) * rate;
            tamount = amount;
        }
    }
    public void print(){
        System.out.println("Total Number of Hours : "+(ehour-shour));
        System.out.println("Amount : "+amount);
        System.out.println("Discount : "+discount);
        System.out.println("Addtn charges : "+adtnl);
        System.out.println("Total amnt : "+tamount);
    }
}
