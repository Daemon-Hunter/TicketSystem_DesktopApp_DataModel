/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import people.User;
import tickets.Ticket;

/**
 *
 * @author 10467841
 */
public interface IBookingFactory {
    
    public Booking createBooking(Ticket ticket, User user, Integer quantity);
    
}
