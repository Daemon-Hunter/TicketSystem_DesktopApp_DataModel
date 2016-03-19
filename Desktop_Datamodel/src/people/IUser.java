/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import bookings.Booking;
import java.util.LinkedList;

/**
 *
 * @author 10512691
 */
public interface IUser extends IPerson {
    
    LinkedList<Booking> getBookings();
    Booking getBooking(Integer bookingId);
    
    String getAddress();
    Boolean setAddress(String address);
    
    String getPostcode();
    Boolean setPostcode(String postcode);
}
