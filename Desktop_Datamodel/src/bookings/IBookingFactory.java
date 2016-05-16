/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import tickets.ITicket;

/**
 * The interface Booking factory is used by any class wishing
 * to be used create an IBooking type.
 *
 * @author Joshua Kellaway
 * @author Charles Gillions
 */
public interface IBookingFactory {
     /**
      * Create booking booking.
      *
      * @param ticket   the ticket that you wish to make a booking for
      * @param order    the order that contains the user that is making the booking
      * @param quantity the amount of tickets that you are making a booking for
      * @return the new booking object that has been created
      */
     IBooking createBooking(ITicket ticket, IOrder order, Integer quantity);
}
