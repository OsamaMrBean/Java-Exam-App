import java.util.Scanner;
import CUSTOMERS.*;
import SERVICES.*;
import VEHICLE_BOOKING.*;
import CAB.*;

public class Main {
    public static void main(String[] args) {
        int x =0;
        Scanner s = new Scanner(System.in);

        //Travel agency details
        System.out.println("Enter travel agency name and phone number");
        String tname,tph;
        tname = s.nextLine();
        tph = s.nextLine();
        TravelAgency ta = new TravelAgency(tname,tph);

        //Available Car Details
        System.out.println("Enter the available car details:-");
        String dname,dnum,vnum;

        System.out.println("Enter the Mini details along with driver details");
        vnum = s.nextLine();
        dname = s.nextLine();
        dnum = s.nextLine();
        Driver mini = new Driver(vnum,"mini",dname,dnum);
        mini.avail = "Y";

        System.out.println("Enter the prime details along with driver details");
        vnum = s.nextLine();
        dname = s.nextLine();
        dnum = s.nextLine();
        Driver prime = new Driver(vnum,"prime",dname,dnum);

        System.out.println("Enter the auto details along with driver details");
        vnum = s.nextLine();
        dname = s.nextLine();
        dnum = s.nextLine();
        Driver auto = new Driver(vnum,"auto",dname,dnum);

        System.out.println("Enter the bike details along with driver details");
        vnum = s.nextLine();
        dname = s.nextLine();
        dnum = s.nextLine();
        Driver bike = new Driver(vnum,"bike",dname,dnum);

        //Customer Details
        System.out.println("Enter the Customer details");
        String name,mobile,street,area,pin;
        System.out.println("Give the customers name,mobile,street,area and pin");
        name = s.nextLine();
        mobile = s.nextLine();
        street = s.nextLine();
        area = s.nextLine();
        pin = s.nextLine();
        Customer c = new Customer(name,mobile,street,area,pin);
        //Booking
        while(true) {
            System.out.println("Give required cab type");
            String req;
            req = s.nextLine();
            if (req.equalsIgnoreCase("mini")) {
                if (mini.avail == "Y") {
                    Booking b = new Booking();
                    mini.avail = "N";
                    System.out.println("Give source and dest");
                    String source, dest;
                    source = s.nextLine();
                    dest = s.nextLine();
                    b.source = source;
                    b.dest = dest;
                    System.out.println("Give the hour and min of the booking");
                    int bhour, bmin;
                    bhour = s.nextInt();
                    bmin = s.nextInt();
                    b.min = bmin;
                    b.hour = bhour;
                    b.ctype = "mini";
                    Trip t = new Trip();
                    t.bookingId = b.Bookingid;
                    t.dnum = mini.Dnum;
                    System.out.println("Give trip start time and end time");
                    int hour, min;
                    hour = s.nextInt();
                    min = s.nextInt();
                    t.smin = min;
                    t.shour = hour;
                    hour = s.nextInt();
                    min = s.nextInt();
                    t.emin = min;
                    t.ehour = hour;
                    t.calc(bhour, bmin, mini.Amountm);
                    b.status = "Attended";
                    System.out.println("BILL DETAILS !!!");
                    ta.print();
                    c.print();
                    System.out.println("Source : " + b.source + "\t\tDestination : " + b.dest);
                    System.out.println("Start time : " + t.shour + " " + t.smin);
                    System.out.println("End time : " + t.ehour + " " + t.emin);
                    System.out.println("Date : " + b.date);
                    t.print();
                    mini.print();
                } else
                    System.out.println("Preferred cab type not available");
            }
            if (req == "prime") {
                if (prime.avail == "Y") {

                } else
                    System.out.println("Preferred cab type not available");
            }
            if (req == "auto") {
                if (auto.avail == "Y") {

                } else
                    System.out.println("Preferred cab type not available");
            }
            if (req == "bike") {
                if (bike.avail == "Y") {

                } else
                    System.out.println("Preferred cab type not available");
            }
            else
                System.out.println("Pls select correct options");
            System.out.println("Enter 1 to exit");
            int counter = s.nextInt();
            if (counter == 1)
                break;
            System.out.println("Enter new cab choice");
        }
    }
}
