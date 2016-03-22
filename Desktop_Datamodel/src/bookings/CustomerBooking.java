/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import database.DatabaseTable;
import java.util.Date;
import people.Customer;
import people.User;
import tickets.Ticket;
import utilities.observer.IObserver;

/**
 *
 * @author 10512691
 */
public class CustomerBooking extends Booking {
    
    /**
     * Use this constructor when creating a booking object from the database.
     * @param ID
     * @param ticket
     * @param ticketQty
     * @param dateTime
     * @param cust 
     */
    public CustomerBooking (Integer ID, Ticket ticket, Integer ticketQty, Date dateTime,
            Customer cust) {
        super(ID, ticket, cust, ticketQty, dateTime);
        user = cust;
        table = DatabaseTable.BOOKING;
    }
    
    /**
     * Use this constructor when creating a new customer booking object.
     * @param ticket
     * @param ticketQty
     * @param dateTime
     * @param cust 
     */
    public CustomerBooking (Ticket ticket, Integer ticketQty, Date dateTime,
            Customer cust) {
        super(ticket, cust, ticketQty, dateTime);
        user = cust;
        table = DatabaseTable.BOOKING;
    }
}
