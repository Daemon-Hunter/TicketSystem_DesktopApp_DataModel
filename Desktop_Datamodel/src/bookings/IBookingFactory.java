/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import tickets.ITicket;

/**
 *
 * @author 10467841
 */
public interface IBookingFactory {
     IBooking createBooking(ITicket ticket, IOrder order, Integer quantity);
}
