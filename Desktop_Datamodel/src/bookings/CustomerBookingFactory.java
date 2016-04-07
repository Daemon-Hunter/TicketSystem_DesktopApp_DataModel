/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import people.Customer;
import people.User;
import tickets.Ticket;

/**
 *
 * @author 10512691
 */
public class CustomerBookingFactory implements IBookingFactory {

    @Override
    public IBooking createBooking(Ticket ticket, User user, Integer quantity) {
        return new CustomerBooking(0, ticket, quantity, null, (Customer)user);
    }
}
