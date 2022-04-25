package VEHICLE_BOOKING;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
    public String Bookingid,status,ctype,source,dest;
    public int hour,min;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    public String date = df.format(new Date());
}
