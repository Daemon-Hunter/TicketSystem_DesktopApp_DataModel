package database;

import bookings.CustomerBooking;
import people.Customer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dominic on 20/04/2016.
 */
public class ObjectToMap {

    public static Map<String,String> ConvertBooking(CustomerBooking aBooking)
    {
        Map<String,String> returnMap = new HashMap<>();
        returnMap.put("BOOKING_ID",Integer.toString(aBooking.getBookingID()));
        returnMap.put("TICKET_ID", Integer.toString(aBooking.getTicket().getID()));
        returnMap.put("ORDER_ID",Integer.toString(aBooking.getOrder().getOrderID()));
        returnMap.put("BOOKING_QUANTITY",Integer.toString(aBooking.getQuantity()));
        returnMap.put("BOOKING_DATE_TIME",aBooking.getBookingTime().toString());
        return returnMap;
    }

    public static Map<String,String> ConvertCustomer(Customer aCustomer)
    {
        Map<String,String> returnMap = new HashMap<>();
        returnMap.put("CUSTOMER_ID",Integer.toString(aCustomer.getID()));
        returnMap.put("CUSTOMER_FIRST_NAME",aCustomer.getFirstName());
        returnMap.put("CUSTOMER_LAST_NAME",aCustomer.getLastName());
        returnMap.put("CUSTOMER_EMAIL",aCustomer.getEmail());
        returnMap.put("CUSTOMER_ADDRESS", aCustomer.getAddress());
        returnMap.put("CUSTOMER_POSTCODE",aCustomer.getPostcode());
        //May need to add password depending on where the registration is taking place.
        return returnMap;
    }



}

