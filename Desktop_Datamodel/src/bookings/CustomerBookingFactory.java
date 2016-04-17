/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import tickets.Ticket;

/**
 *
 * @author 10512691
 */
public class CustomerBookingFactory implements IBookingFactory  {

    @Override
    public IBooking createBooking(Ticket ticket, IOrder order, Integer quantity) {
        return new CustomerBooking(ticket, quantity, null, order);
    }

    
}
