/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import people.Customer;
import tickets.Ticket;

/**
 *
 * @author 10512691
 */
public interface IBookingFactory {
    
    public Booking createBooking(Ticket ticket, Customer customer, Integer quantity);
}
