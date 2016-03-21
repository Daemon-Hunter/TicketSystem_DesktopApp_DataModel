/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import bookings.IBooking;
import java.util.LinkedList;
import tickets.Ticket;

/**
 *
 * @author 10512691
 */
public interface IUser extends IPerson {
    
    LinkedList<IBooking> getBookings();
    LinkedList<IBooking> getBookingByTicket(Ticket ticket);
    
    String getAddress();
    Boolean setAddress(String address);
    
    Boolean getCustomerID();
    
    String getPostcode();
    Boolean setPostcode(String postcode);
}
